//
// Created by naor on 5/29/19.
//

#ifndef CLD3_NATIVE_CLD3LANGDETECTOR_H
#define CLD3_NATIVE_CLD3LANGDETECTOR_H

class Cld3LangDetector {
public:
    long create();
    long create(int min_num_bytes, int max_num_bytes);

    void deallocate(long ptr);

    void detect(long ptr, const char *text, const char *into);
};

#endif //CLD3_NATIVE_CLD3LANGDETECTOR_H
