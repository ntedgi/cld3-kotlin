# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/naor/Downloads/clion-2019.1.3/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/naor/Downloads/clion-2019.1.3/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/cld3_native.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/cld3_native.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/cld3_native.dir/flags.make

CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.o: CMakeFiles/cld3_native.dir/flags.make
CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.o: ../Cld3LangDetector.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.o -c /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/Cld3LangDetector.cpp

CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/Cld3LangDetector.cpp > CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.i

CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/Cld3LangDetector.cpp -o CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.s

CMakeFiles/cld3_native.dir/runner.cpp.o: CMakeFiles/cld3_native.dir/flags.make
CMakeFiles/cld3_native.dir/runner.cpp.o: ../runner.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/cld3_native.dir/runner.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/cld3_native.dir/runner.cpp.o -c /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/runner.cpp

CMakeFiles/cld3_native.dir/runner.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/cld3_native.dir/runner.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/runner.cpp > CMakeFiles/cld3_native.dir/runner.cpp.i

CMakeFiles/cld3_native.dir/runner.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/cld3_native.dir/runner.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/runner.cpp -o CMakeFiles/cld3_native.dir/runner.cpp.s

# Object files for target cld3_native
cld3_native_OBJECTS = \
"CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.o" \
"CMakeFiles/cld3_native.dir/runner.cpp.o"

# External object files for target cld3_native
cld3_native_EXTERNAL_OBJECTS =

libcld3_native.so: CMakeFiles/cld3_native.dir/Cld3LangDetector.cpp.o
libcld3_native.so: CMakeFiles/cld3_native.dir/runner.cpp.o
libcld3_native.so: CMakeFiles/cld3_native.dir/build.make
libcld3_native.so: CMakeFiles/cld3_native.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX shared library libcld3_native.so"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/cld3_native.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/cld3_native.dir/build: libcld3_native.so

.PHONY : CMakeFiles/cld3_native.dir/build

CMakeFiles/cld3_native.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/cld3_native.dir/cmake_clean.cmake
.PHONY : CMakeFiles/cld3_native.dir/clean

CMakeFiles/cld3_native.dir/depend:
	cd /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug /home/naor/Desktop/cld3kotlin/src/main/cpp/cld3/src/cmake-build-debug/CMakeFiles/cld3_native.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/cld3_native.dir/depend

