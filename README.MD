[![Build Status](https://travis-ci.com/ntedgi/cld3-kotlin-wrapper.svg?branch=master)](https://travis-ci.com/ntedgi/cld3-kotlin-wrapper) [![Coverage Status](https://coveralls.io/repos/github/ntedgi/cld3-kotlin-wrapper/badge.svg)](https://coveralls.io/github/ntedgi/cld3-kotlin-wrapper)

# cld3-kotlin-wrapper
Kotlin Wrapper for [CLD3](https://github.com/google/cld3) -  Google's Compact Language Detector 3 

Bridge from c++ to Kotlin using [Java Abstracted Foreign Function Layer](https://github.com/jnr/jnr-ffi)


## C++ 
```
  std::vector<Result> FindTopNMostFreqLangs(const string &text, int num_langs);
```
```
  Result FindLanguage(const string &text);
```

## Kotlin
```
fun findTopNMostFreqLangs(text: String, n: Int): List<LangDetectResponse> 
```

```
fun detect(text: String): LangDetectResponse 
```