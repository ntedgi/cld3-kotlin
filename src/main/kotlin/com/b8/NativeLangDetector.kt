package com.b8

import jnr.ffi.annotations.In
import jnr.ffi.annotations.Out

interface  NativeLangDetector{
    fun create(): Long
    fun create1( @In min_num_bytes: Int,  @In max_num_bytes: Int): Long
    fun deallocate( @In ptr: Long)
    fun detect( @In ptr: Long, @In text: String, @Out into: ByteArray)
    fun findTopNMostFreqLangs( @In ptr:Long, @In text: String, @Out into: ByteArray,  @In num_langs:Int)
}