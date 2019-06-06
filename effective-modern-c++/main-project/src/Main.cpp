#include <iostream>

#include "Item21.h"
#include "Item31.h"


int main (int argc, char *argv[]) {
    std::cout << "Starting to run items!\n";

    Item21 item21;
    item21.run();

    Item31 item31;
    item31.run();

    return 0;
}