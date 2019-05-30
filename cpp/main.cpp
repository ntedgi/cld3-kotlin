#include <iostream>
#include "Cld3LangDetector.h"


int main() {

    char * response ;
    const char *text = "Because pointers are not arrays";
    Cld3LangDetector ld = Cld3LangDetector();
    long ptrToDetector = ld.create();
    ld.detect(ptrToDetector,text,response);
    std::cout << "Hello, World!" << std::endl;
    return 0;


}