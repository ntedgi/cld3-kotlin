package com.b8

import org.junit.Test


internal class LangDetectTest {


        @Test
        fun `Simple Build And Predict On English Text`() {
            val englishText = "This piece of text is in English";
            val ld = LangDetect()
            val result = ld.detect(englishText)
            assert(result.language == "en")
            assert(result.isReliable)
            assert(result.proportion == 1f)
        }

        @Test
        fun `Simple Build And Predict On Russian Text`() {
            val englishText = "Този текст е на Български.";
            val ld = LangDetect()
            val result = ld.detect(englishText)
            assert(result.language == "bg")
            assert(result.isReliable)
            assert(result.proportion == 1f)
        }
        @Test
        fun `Simple Build And Predict On English and Russian Text and n = 3`() {
            val englishText = "This piece of text is in English Този текст е на Български";
            val ld = LangDetect()
            val result = ld.findTopNMostFreqLangs(englishText, 3)
            val languages = result.map { it.language }
            assert(languages.size == 3)
            assert(languages.contains("en"))
            assert(languages.contains("bg"))
            assert(languages.contains("und"))

        }

        @Test
        fun `Simple Build And Predict On English and Russian Text and n = 2`() {
            val englishText = "Този текст е на Български This piece of text is in English ";
            val ld = LangDetect()
            val result = ld.findTopNMostFreqLangs(englishText, 2)
            val languages = result.map { it.language }
            assert(languages.size == 2)
            assert(languages.contains("en"))
            assert(languages.contains("bg"))
        }
}