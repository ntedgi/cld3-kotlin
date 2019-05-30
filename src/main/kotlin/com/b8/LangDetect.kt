package com.b8

import jnr.ffi.LibraryLoader
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.StandardCharsets


const val LANGUAGE_DETECT_SHARED_FILE = "libnative.so"
const val MIN_NUM_OF_BYTES = 0
const val MAX_NUM_OF_BYTES = 10000
const val SINGLE_LANGUAGE_DETECTION_BUFFER_SIZE = 100
const val MULTI_LANGUAGE_DETECTION_BUFFER_SIZE = 300

val LIB_PATH = "${System.getProperty("user.dir")}/src/main/lib/"


data class LangDetectResponse(val probability: Float, val proportion: Float, val isReliable: Boolean, val language: String)

class LangDetect : AutoCloseable {

    private var ptr: Long = -1
    private val detector: NativeLangDetector

    init {
        System.load("$LIB_PATH$LANGUAGE_DETECT_SHARED_FILE")
        detector = LibraryLoader.create(NativeLangDetector::class.java).load("native")
        ptr = detector.create1(MIN_NUM_OF_BYTES, MAX_NUM_OF_BYTES)
    }

    fun detect(text: String): LangDetectResponse {
        val buffer = ByteArray(SINGLE_LANGUAGE_DETECTION_BUFFER_SIZE)
        detector.detect(ptr, text, buffer)

        ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).let {
            return extractResponseFromByteBuffer(it)
        }
    }

    private fun extractResponseFromByteBuffer(byteBuffer: ByteBuffer): LangDetectResponse {
        val probability = byteBuffer.float
        val proportion = byteBuffer.float
        val isReliable = byteBuffer.short
        val sizeOfLang = byteBuffer.int
        val languageBuffer = ByteArray(sizeOfLang) { 127.toByte() }
        byteBuffer.get(languageBuffer, 0, sizeOfLang)
        val language = String(languageBuffer, StandardCharsets.UTF_8)
        return LangDetectResponse(probability, proportion, isReliable.toInt() == 1, language)
    }

    fun findTopNMostFreqLangs(text: String, n: Int): List<LangDetectResponse> {
        val buffer = ByteArray(MULTI_LANGUAGE_DETECTION_BUFFER_SIZE)
        detector.findTopNMostFreqLangs(ptr, text, buffer, n)
        val result = ArrayList<LangDetectResponse>()
        ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).let { byteBuffer ->
            val size = byteBuffer.int
            repeat(size) {
                result.add(extractResponseFromByteBuffer(byteBuffer))
            }
        }
        return result.toList()

    }


    override fun close() {
        detector.deallocate(ptr)
    }


}