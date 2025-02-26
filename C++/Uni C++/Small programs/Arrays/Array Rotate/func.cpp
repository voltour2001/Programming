#include <iostream>

void rotateArray(int * arr, int size){

    //* Empty Array
    if (size == 0){
        return;
    }

    //* Get Last
    int last = arr[size -1];


    //* Shift elements one position
    for (int  i = size - 1; i > 0; i--)
    {
        arr[i] = arr[i-1];
    }


    //* Place last element into first pos
    arr[0] = last;



}


//! Helper function to print the array
void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}