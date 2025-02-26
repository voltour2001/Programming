#include <iostream>

//! Return Sum of all elements in array
// 1 2 3 4 5 
// Sum: 15

int arrSum(int * arr, int size){

    int sum = 0;
    int * p = arr;

    for (size_t i = 0; i < size; i++)
    {
        sum += *(p+i);
    }
    
    return sum;

}

void printArr(int * arr, int size){

    for (size_t i = 0; i < size; i++)
    {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
    
}

int main(){
    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    int sum = arrSum(arr, size);

    printArr(arr, size);
    std::cout << "Sum: "<< sum << std::endl;
}