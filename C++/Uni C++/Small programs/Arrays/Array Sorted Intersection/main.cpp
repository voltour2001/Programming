#include <iostream>
#include <vector>
using namespace std;

//! Return common elements in 2 arrays
// Array 1: 1 3 4 5 7 
// Array 2: 2 3 5 6 
// Intersection: 3 5 


void findIntersection(int* arr1, int size1, int* arr2, int size2, vector<int>& result ){
    int * p1 = arr1;
    int * p2 = arr2;

    while (p1 < arr1 + size1 && p2 < arr2 + size2)
    {
        if (*p1 == *p2)
        {
            result.push_back(*p1);
            p1++;
            p2++;
        }else if (*p1<*p2)
        {
            p1++;
        }else{
            p2++;
        }
        
    }
    
}

void printVector(vector<int>& vec){
    for(auto val : vec)
    {
        cout << val << " ";
    }
    cout << endl;
}

void printArray(const int* arr, int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

int main(){

    int arr1[] = {1,3,4,5,7};
    int arr2[] = {2,3,5,6};

    int size1 = sizeof(arr1) / sizeof(arr1[0]);
    int size2 = sizeof(arr2) / sizeof(arr2[0]);

    vector<int> intersection;

    std::cout << "Array 1: ";
    printArray(arr1, size1);

    std::cout << "Array 2: ";
    printArray(arr2, size2);

    findIntersection(arr1, size1, arr2, size2, intersection);

        std::cout << "Intersection: ";
    printVector(intersection);

    return 0;
}