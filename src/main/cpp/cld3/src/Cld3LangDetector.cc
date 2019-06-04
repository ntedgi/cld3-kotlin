//
// Created by naor on 5/29/19.
//

#include "Cld3LangDetector.h"
#include "../nnet_language_identifier.h"

using namespace chrome_lang_id;

long create() {
    return (long) new NNetLanguageIdentifier();
}

long create1(int min_num_bytes, int max_num_bytes) {
    return (long) new NNetLanguageIdentifier(min_num_bytes, max_num_bytes);
}

void deallocate(long ptr) {
    NNetLanguageIdentifier *nptr = (NNetLanguageIdentifier *) ptr;
    delete nptr;
}

void detect(long ptr, const char *text, const char *into) {

    NNetLanguageIdentifier *nptr = (NNetLanguageIdentifier *) ptr;
    NNetLanguageIdentifier::Result res = nptr->FindLanguage(text);

    long current = (long) into;

    *((float *) current) = res.probability;
    current += sizeof(float);

    *((float *) current) = res.proportion;
    current += sizeof(float);
    *((short *) current) = res.is_reliable;
    current += sizeof(short);
    *((int *) current) = res.language.size();
    current += sizeof(int);

    memccpy(reinterpret_cast<void *>(current), res.language.c_str(), res.language.size() + 1, sizeof(res.language));


}


void findTopNMostFreqLangs(long ptr, const char *text, const char *into, int num_langs) {

    NNetLanguageIdentifier *nptr = (NNetLanguageIdentifier *) ptr;

    const std::vector<NNetLanguageIdentifier::Result> results =
            nptr->FindTopNMostFreqLangs(text, num_langs);


    long current = (long) into;


    int size = (int )results.size();
    *((int *) current) = size;
    current += sizeof(int);


    for (const NNetLanguageIdentifier::Result &res : results) {

        *((float *) current) = res.probability;
        current += sizeof(float);

        *((float *) current) = res.proportion;
        current += sizeof(float);

        *((short *) current) = res.is_reliable;
        current += sizeof(short);

        *((int *) current) = res.language.size();
        current += sizeof(int);

        memccpy(reinterpret_cast<void *>(current), res.language.c_str(), res.language.size() + 1, sizeof(res.language));
        current += sizeof(char) * res.language.size();
    }


}



