#include <iostream>

//! Return the index of the first occurence of target int
// Array: 5 3 7 9 2 8 7 
// Target : 7
// First occurrence of 7 is at index: 2

int findFirst(int * arr, int size, int& target){

    int * p = arr;

    for (size_t i = 0; i < size; i++)
    {
        if (*(p+i) == target)
        {
            return i;
        }
    }
    return -1;
    

}


void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}


int main() {
    int arr[] = {5, 3, 7, 9, 2, 8, 7};
    int size = sizeof(arr) / sizeof(arr[0]);
    int target = 7;


    std::cout << "Array: ";
    printArray(arr, size);


    int index = findFirst(arr, size, target);

    if (index != -1) {
        std::cout << "Target : " << target <<  std::endl;
        std::cout << "First occurrence of " << target << " is at index: " << index << std::endl;
    } else {
        std::cout << "Value " << target << " not found in the array." << std::endl;
    }

}