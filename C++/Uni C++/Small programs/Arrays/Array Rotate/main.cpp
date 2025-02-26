#include <iostream>
#include "func.cpp"

//! Return array after rotating it x times
// Num of rotations: 2
// Original array:
// 1 2 3 4 5
// Array after 2 rotations:
// 4 5 1 2 3

int main() {

    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);
    int rotations;

    std::cout << "Num of rotations: ";
    std::cin >> rotations;

    std::cout << "Original array: " << std::endl;
    printArray(arr, size);

    // rotations = 3;

    // Call rotateArray 'rotations' times
    for (int i = 0; i < rotations; i++) {
        rotateArray(arr, size);
    }

    std::cout << "Array after " << rotations << " rotations: " << std::endl;
    printArray(arr, size);

    return 0;
}