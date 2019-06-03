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
const val UNKNOWN_LANGUAGE = "UNKNOWN"

val LIB_PATH = "${System.getProperty("user.dir")}/src/main/lib/"


data class LangDetectResponse(
    val probability: Float,
    val proportion: Float,
    val isReliable: Boolean,
    val language: String
)

class LangDetect : AutoCloseable {

    private val fullLanguageName = mapOf(
        "eo" to "Esperanto",
        "co" to "Corsican",
        "eu" to "Basque",
        "ta" to "Tamil",
        "de" to "German",
        "mt" to "Maltese",
        "ps" to "Pushto",
        "te" to "Telugu",
        "su" to "Sundanese",
        "uz" to "Uzbek",
        "ne" to "Nepali",
        "nl" to "Dutch",
        "sw" to "Swahili",
        "sq" to "Albanian",
        "ja" to "Japanese",
        "no" to "Norwegian",
        "mn" to "Mongolian",
        "so" to "Somali",
        "ko" to "Korean",
        "kk" to "Kazakh",
        "sl" to "Slovenian",
        "mr" to "Marathi",
        "th" to "Thai",
        "zu" to "Zulu",
        "ml" to "Malayalam",
        "hr" to "Croatian",
        "bs" to "Bosnian",
        "lo" to "Lao",
        "sd" to "Sindhi",
        "cy" to "Welsh",
        "hy" to "Armenian",
        "uk" to "Ukrainian",
        "pt" to "Portuguese",
        "lv" to "Latvian",
        "cs" to "Czech",
        "vi" to "Vietnamese",
        "jv" to "Javanese",
        "be" to "Belarusian",
        "km" to "Khmer",
        "mk" to "Macedonian",
        "tr" to "Turkish",
        "fy" to "Western Frisian",
        "am" to "Amharic",
        "zh" to "Chinese",
        "da" to "Danish",
        "sv" to "Swedish",
        "fi" to "Finnish",
        "ht" to "Haitian; Haitian Creole",
        "af" to "Afrikaans",
        "la" to "Latin",
        "id" to "Indonesian",
        "sm" to "Samoan",
        "ca" to "Catalan",
        "ka" to "Georgian",
        "sr" to "Serbian",
        "it" to "Italian",
        "sk" to "Slovak",
        "ru" to "Russian",
        "bg" to "Bulgarian",
        "ny" to "Nyanja; Chichewa; Chewa",
        "fa" to "Persian",
        "gl" to "Galician",
        "et" to "Estonian",
        "ms" to "Malay",
        "gd" to "Gaelic; Scottish Gaelic",
        "ha" to "Hausa",
        "is" to "Icelandic",
        "ur" to "Urdu",
        "mi" to "Maori",
        "hi" to "Hindi",
        "bn" to "Bengali",
        "fr" to "French",
        "yi" to "Yiddish",
        "hu" to "Hungarian",
        "xh" to "Xhosa",
        "my" to "Burmese",
        "tg" to "Tajik",
        "ro" to "Romanian",
        "ar" to "Arabic",
        "lb" to "Luxembourgish",
        "kn" to "Kannada",
        "az" to "Azerbaijani",
        "si" to "Sinhala; Sinhalese",
        "ky" to "Kirghiz",
        "mg" to "Malagasy",
        "en" to "English",
        "gu" to "Gujarati",
        "es" to "Spanish",
        "pl" to "Polish",
        "ga" to "Irish",
        "lt" to "Lithuanian",
        "sn" to "Shona",
        "yo" to "Yoruba",
        "pa" to "Panjabi",
        "ku" to "Kurdish",
        "zh-Latn" to "Chinese-Latin",
        "bg-Latn" to "Bulgarian-Latin",
        "ru-Latn" to "Russian-Latin",
        "hi-Latn" to "Hindi-Latin",
        "ja-Latn" to "Japanese-Latin",
        "st" to "Sotho,Southern",
        "el" to "Greek",
        "el-Latn" to "Greek-Latin",
        "hmn" to "Hmong, Mong",
        "ig" to "Igbo",
        "iw" to "Hebrew",
        "fil" to "Filipino",
        "haw" to "Hawaiian",
        "ceb" to "Cebuano"
    )

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

    fun changeLanguageCodeToFullName(languageCode: String): String {
        return fullLanguageName[languageCode] ?: UNKNOWN_LANGUAGE
    }

    override fun close() {
        detector.deallocate(ptr)
    }


}