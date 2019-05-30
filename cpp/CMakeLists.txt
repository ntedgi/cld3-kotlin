cmake_minimum_required(VERSION 3.13)

project(cld3-jnr)
set(CMAKE_CXX_STANDARD 11)

include_directories(./script_span ./cld_3)
link_directories(./)

#add_executable(opencv-test Test.cpp)
#target_link_libraries(opencv-test opencv_native opencv_core opencv_dnn opencv_imgproc opencv_imgcodecs openblas)


project(cld3_native VERSION 1.0.0 DESCRIPTION "OpenCV native ready rof JNR")

set(SOURCE_FILES Cld3LangDetector.h Cld3LangDetector.cpp main.cpp)
add_library(cld3_native SHARED ${SOURCE_FILES})
#target_include_directories(mylib PRIVATE .)