//
// Created by naor on 5/29/19.
//

#include "Cld3LangDetector.h"
#include "nnet_language_identifier.h"
using namespace chrome_lang_id;

long Cld3LangDetector::create() {
    return (long)new NNetLanguageIdentifier();
}

long Cld3LangDetector::create(int min_num_bytes, int max_num_bytes) {
    return (long)new NNetLanguageIdentifier(min_num_bytes, max_num_bytes);
}

void Cld3LangDetector::deallocate(long ptr) {
    NNetLanguageIdentifier *nptr = (NNetLanguageIdentifier *)ptr;
    delete nptr;
}

void Cld3LangDetector::detect(long ptr, const char *text, const char *into) {
    NNetLanguageIdentifier *nptr = (NNetLanguageIdentifier *)ptr;
    NNetLanguageIdentifier::Result res = nptr->FindLanguage(text);
    long current = (long)into;
    *((float *)current) = res.probability;
    current += sizeof(float);
    *((float *)current) = res.proportion;
    current += sizeof(float);
    *((short *)current) = res.is_reliable;
    current += sizeof(short);
    printf(" %f %f\n",  res.probability, res.proportion);
}


