cmake_minimum_required(VERSION 3.10)

include_directories(${effective-modern-cpp_SOURCE_DIR}/main/inc)

include_directories(${effective-modern-cpp_SOURCE_DIR}/item-21_prefer_std_make_unique_and_std_make_shared_to_direct_use_of_new/inc)
include_directories(${effective-modern-cpp_SOURCE_DIR}/item-31_avoid_default_capture_modes/inc)


link_directories(${effective-modern-cpp_SOURCE_DIR}/item-21_prefer_std_make_unique_and_std_make_shared_to_direct_use_of_new/src)
link_directories(${effective-modern-cpp_SOURCE_DIR}/item-31_avoid_default_capture_modes/src)


add_executable(main.out Main.cpp)
target_link_libraries(main.out item-21 item-31)