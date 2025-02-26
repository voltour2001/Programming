#include <iostream>

//! Return biggest element in array

void findMax(int * arr, int size){
    int * p = arr;
    int max = *p;
    for (size_t i = 0; i < size; i++)
    {
        if (*(p+i) > max)
        {
            max = *(p+i);
        }
        
    }
    std::cout << "Max = " << max;
    
}


int main(){

    int arr[] = {3, 7, 2, 8, 5, 9, 1};
    int size = sizeof(arr) / sizeof(arr[0]);

    
    //* Print Array
    for (size_t i = 0; i < size; i++)
    {
        std::cout << "[ " << arr[i] << " ], ";
    }
    std::cout << " " << std::endl;
    
    findMax(arr, size);

}
