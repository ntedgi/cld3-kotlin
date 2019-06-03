[![Build Status](https://travis-ci.com/ntedgi/cld3-kotlin.svg?branch=master)](https://travis-ci.com/ntedgi/cld3-kotlin) [![codecov](https://codecov.io/gh/ntedgi/cld3-kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/ntedgi/cld3-kotlin)


# cld3-kotlin-wrapper
Kotlin Wrapper for [CLD3](https://github.com/google/cld3) -  Google's Compact Language Detector 3 

Bridge from c++ to Kotlin using [Java Abstracted Foreign Function Layer](https://github.com/jnr/jnr-ffi)


## Usage : 
```kotlin
    val ld = LangDetect()

    val englishText = "This piece of text is in English";
    var result = ld.detect(englishText)
    assert(result.language == "English")
    assert(result.isReliable)
    assert(result.proportion == 1f)

    val englishBulgarianText = "This piece of text is in English Този текст е на Български";
    val results = ld.findTopNMostFreqLangs(englishBulgarianText, 3)
    val languages = results.map { it.language }
    assert(languages.size == 3)
    assert(languages.contains("English"))
    assert(languages.contains("Bulgarian"))
    assert(languages.contains("UNKNOWN"))
```




## The Interface Implemantation:
 
## C++ 
```cpp
std::vector<Result> FindTopNMostFreqLangs(const string &text, int num_langs);
```
```cpp
Result FindLanguage(const string &text);
```

## Kotlin
```kotlin
fun findTopNMostFreqLangs(text: String, n: Int): List<LangDetectResponse> 
```

```kotlin
fun detect(text: String): LangDetectResponse 
```
