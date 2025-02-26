#include <iostream>

//! Prints how many odd or even numbers in array
// Array: 1 2 3 4 5 6 7 8 
// Number of even elements: 4
// Number of odd elements: 4

void countEvenOdd(int * arr, int size, int& evenCount, int& oddCount){
    evenCount = 0;
    oddCount = 0;

    int * p = arr;

    for (size_t i = 0; i < size; i++)
    {
        if (*(p+i)%2 == 0)
            evenCount++;
        else
            oddCount++;
    }
}

void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}


int main() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int size = sizeof(arr) / sizeof(arr[0]);


    std::cout << "Array: ";
    printArray(arr, size);

    int evenCount, oddCount;
    countEvenOdd(arr, size, evenCount, oddCount);

    std::cout << "Number of even elements: " << evenCount << std::endl;
    std::cout << "Number of odd elements: " << oddCount << std::endl;

    return 0;
}