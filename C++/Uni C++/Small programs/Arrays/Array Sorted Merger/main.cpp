#include <iostream>

//! Merges two sorted arrays into a single sorted array and prints the result
// Array 1: 1 3 5 7 9 11 13 
// Array 2: 2 4 6 8 10
// Merged Array: 1 2 3 4 5 6 7 8 9 10 11 13

void mergeArrays(int * arr1, int size1, int * arr2, int size2, int* mergedArr){
    int * p1 = arr1;
    int * p2 = arr2;

    int * pM = mergedArr;

    int count1 = 0;
    int count2 = 0;

    while (count1 < size1 && count2 < size2) {
        if (*p1 < *p2) {
            *pM = *p1;
            p1++;
            count1++; 
        } else {
            *pM = *p2;
            p2++;
            count2++; 
        }
        pM++; 
    }
    
    while (count1 < size1){
        *pM = *p1;
        p1++;
        pM++;
        count1++;
    }

    while (count2 < size2){
        *pM = *p2;
        p2++;
        pM++;
        count2++;
    }

}

void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}


int main() {
    int arr1[] = {1, 3, 5, 7, 9 ,11, 13};
    int arr2[] = {2, 4, 6, 8, 10};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);
    int size2 = sizeof(arr2) / sizeof(arr2[0]);
    int mergedSize = size1 + size2;

    int* mergedArr = new int[mergedSize]; // Dynamic allocation for merged array

    std::cout << "Array 1: ";
    printArray(arr1, size1);

    std::cout << "Array 2: ";
    printArray(arr2, size2);

    mergeArrays(arr1, size1, arr2, size2, mergedArr);

    std::cout << "Merged Array: ";
    printArray(mergedArr, mergedSize);

    delete[] mergedArr; // Free dynamically allocated memory

    return 0;
}