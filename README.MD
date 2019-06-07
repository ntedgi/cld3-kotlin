[![Build Status](https://travis-ci.com/ntedgi/cld3-kotlin.svg?branch=master)](https://travis-ci.com/ntedgi/cld3-kotlin) [![codecov](https://codecov.io/gh/ntedgi/cld3-kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/ntedgi/cld3-kotlin)
[![codebeat badge](https://codebeat.co/badges/a92dd040-a71c-4644-96a9-daad0aeb9ac4)](https://codebeat.co/projects/github-com-ntedgi-cld3-kotlin-master) [![](https://jitpack.io/v/ntedgi/cld3-kotlin.svg)](https://jitpack.io/#ntedgi/cld3-kotlin)

# cld3-kotlin
Kotlin Wrapper for [CLD3](https://github.com/google/cld3) -  Google's Compact Language Detector 3 

Bridge from c++ to Kotlin using [Java Abstracted Foreign Function Layer](https://github.com/jnr/jnr-ffi)


## Usage Examples: 


### add maven dependencies

```maven
<repositories>
     <repository>
         <id>jitpack.io</id>
         <url>https://jitpack.io</url>
     </repository>
 </repositories>
 ...
 <dependency>
      <groupId>com.github.ntedgi</groupId>
      <artifactId>cld3-kotlin</artifactId>
      <version>master-243b20b6d7-1</version>
 </dependency>
```

### download [os shred objects](https://github.com/ntedgi/cld3-kotlin/tree/master/src/main/lib) and add them under src/lib/(os-name)


```kotlin
val ld = LangDetect()
val englishText = "This piece of text is in English";
var result = ld.detect(englishText)
assert(result.language == "English")
assert(result.isReliable)
assert(result.proportion == 1f)
```


```kotlin
val ld = LangDetect()
val englishBulgarianText = "This piece of text is in English Този текст е на Български";
val results = ld.findTopNMostFreqLangs(englishBulgarianText, 3)
val languages = results.map { it.language }
assert(languages.size == 3)
assert(languages.contains("English"))
assert(languages.contains("Bulgarian"))
assert(languages.contains("UNKNOWN"))
```


## Operations Systems Support:

|Job | OS | State| Shared Objects|
|:------------- | :-------------:| :-------------:| :-------------:|
|[47.1](https://travis-ci.com/ntedgi/cld3-kotlin/builds/114315426)  | macOS | passed| [dylib](https://github.com/ntedgi/cld3-kotlin/tree/master/src/main/lib/osx) 
|[47.2](https://travis-ci.com/ntedgi/cld3-kotlin/builds/114315426)  | Linux | passed|[so](https://github.com/ntedgi/cld3-kotlin/tree/master/src/main/lib/unix) 
| -  | windows |not supported |-|



## The Bridge Interface Implemantation:
 
## from (C++) 
```cpp
std::vector<Result> FindTopNMostFreqLangs(const string &text, int num_langs);
```
```cpp
Result FindLanguage(const string &text);
```

## to (Kotlin)
```kotlin
fun findTopNMostFreqLangs(text: String, n: Int): List<LangDetectResponse> 
```

```kotlin
fun detect(text: String): LangDetectResponse 
```

```kotlin
data class LangDetectResponse(
    val probability: Float,
    val proportion: Float,
    val isReliable: Boolean,
    val language: String
)
```
