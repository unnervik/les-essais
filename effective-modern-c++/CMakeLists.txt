cmake_minimum_required(VERSION 3.10)

project(effective-modern-cpp)

set (CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR})

add_subdirectory(main-project)

add_subdirectory(item-21_prefer_std_make_unique_and_std_make_shared_to_direct_use_of_new)
add_subdirectory(item-31_avoid_default_capture_modes)

