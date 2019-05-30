//
// Created by naor on 5/29/19.
//
#include "Cld3LangDetector.h"
#include <stdio.h>

int main(int argc, const char *argv[]) {


    char *test = " Prints each argument on the command line.";
    char *response;
    Cld3LangDetector c = Cld3LangDetector();
    long l = c.create();
    c.detect(l, test,response);
    printf("test");


}