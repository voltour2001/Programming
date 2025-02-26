#include <iostream>

using namespace std;

void swapArrays(int * &arr1, int* &arr2, int size){
    // & to change the arrays directly and not copy to local function variable
    int * temp = arr1;
    arr1 = arr2;
    arr2 = temp;
}


void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int size = 5;

    // Dynamically allocate two arrays
    int* array1 = new int[size]{1, 2, 3, 4, 5};
    int* array2 = new int[size]{6, 7, 8, 9, 10};

    // Print arrays before swap
    printf("%-*s", 21, "Array 1 before swap: ");
    printArray(array1, size);
    printf("%-*s", 21, "Array 2 before swap: ");
    printArray(array2, size);

    // Swap arrays
    swapArrays(array1, array2, size);
    // Print arrays after swap
    printf("%-*s", 21, "Array 1 after swap: ");
    printArray(array1, size);
    printf("%-*s", 21, "Array 2 after swap: ");
    printArray(array2, size);

    // Clean up
    delete[] array1;
    delete[] array2;

    return 0;
}