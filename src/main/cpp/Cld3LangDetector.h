//
// Created by naor on 5/29/19.
//

#ifndef __CLD_3_LANG_DETECTOR__
#define __CLD_3_LANG_DETECTOR__

extern "C" {
long __attribute__ ((visibility ("default"))) create();

long __attribute__ ((visibility ("default"))) create1(int min_num_bytes, int max_num_bytes);

void __attribute__ ((visibility ("default"))) deallocate(long ptr);

void __attribute__ ((visibility ("default"))) detect(long ptr, const char *text, const char *into);

void __attribute__ ((visibility ("default"))) findTopNMostFreqLangs(long ptr, const char *text, const char *into,int num_langs);

}

#endif
