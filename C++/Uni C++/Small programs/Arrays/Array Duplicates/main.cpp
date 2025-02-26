#include <iostream>
#include "duplicates.cpp"

using namespace std;

//! Prints if any duplicates are found inside an array

int main() {
    // Example array for testing
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 1, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    // Call the function and store the result
    bool duplicates = hasDuplicates(arr, size);

    // Output the result
    if (duplicates) {
        cout << "Duplicates found." << endl;
    } else {
        cout << "No duplicates." << endl;
    }

    return 0;
}