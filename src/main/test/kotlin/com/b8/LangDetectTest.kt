package com.b8

import org.junit.Test


internal class LangDetectTest {



    @Test
    fun `Simple Build And Predict On English Text`() {
        val ld = LangDetect()

        val englishText = "This piece of text is in English";
        val result = ld.detect(englishText)
        assert(result.language == "en")
        assert(result.isReliable)
        assert(result.proportion == 1f)
    }

    @Test
    fun `Simple Build And Predict On Russian Text`() {
        val ld = LangDetect()

        val englishText = "Този текст е на Български.";
        val result = ld.detect(englishText)
        assert(result.language == "bg")
        assert(result.isReliable)
        assert(result.proportion == 1f)
    }

    @Test
    fun `Simple Build And Predict On English and Russian Text and n = 3`() {
        val ld = LangDetect()
        val englishText = "This piece of text is in English Този текст е на Български";
        val result = ld.findTopNMostFreqLangs(englishText, 3)
        val languages = result.map { it.language }
        assert(languages.size == 3)
        assert(languages.contains("en"))
        assert(languages.contains("bg"))
        assert(languages.contains("und"))

    }

    @Test
    fun `Simple Build And Predict On English and Russian Text and n = 2`() {
        val ld = LangDetect()

        val englishText = "Този текст е на Български This piece of text is in English ";
        val result = ld.findTopNMostFreqLangs(englishText, 2)
        val languages = result.map { it.language }
        assert(languages.size == 2)
        assert(languages.contains("en"))
        assert(languages.contains("bg"))
    }


    fun assertLanguageResult(text: String, expectedLanguage: String) {
        val ld = LangDetect()
        val result = ld.detect(text).language
        val fullName = ld.changeLanguageCodeToFullName(result)
        assert(fullName == expectedLanguage)
    }

    @Test
    fun `simple language detection hebrew`() {
        assertLanguageResult("מה המצב איתך ? מה המצב יא גבר", "Hebrew")
    }


    @Test
    fun `simple language detection english`() {
        assertLanguageResult("what does the fox says?", "English")
    }

    @Test
    fun `simple language detection spanish`() {
        assertLanguageResult("Hola cómo estás hoy?", "Spanish")
    }
}