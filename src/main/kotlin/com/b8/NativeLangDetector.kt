package com.b8

import jnr.ffi.annotations.In
import jnr.ffi.annotations.Out

interface  NativeLangDetector{
    fun create(): Long
    fun create1(min_num_bytes: Int, max_num_bytes: Int): Long
    fun deallocate(ptr: Long)
    fun detect(ptr: Long, @In text: String, @Out into: ByteArray)
    fun findTopNMostFreqLangs(ptr:Long, @In text: String, @Out into: ByteArray, num_langs:Int)
}