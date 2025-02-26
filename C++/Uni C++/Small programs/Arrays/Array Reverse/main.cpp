#include <iostream>

//! Return reversed array
// Original Array :1 2 3 4 5 
// Reversed Array :5 4 3 2 1

void reverseArray(int * arr, int size){
    int * start = arr;
    int * end = arr+size-1;

    while(start < end){
        int temp = *start;

        *start = *end;
        *end = temp;

        start++; 	// start = next element
        end--;		// end = element before last
    }
}
void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

int main (){

    int arr[] = {1,2,3,4,5};
    int size = sizeof(arr)/sizeof(arr[0]);

    std::cout << "Original Array :";
    printArray(arr, size);

    reverseArray(arr, size);

    std::cout << "Reversed Array :";
    printArray(arr, size);



}