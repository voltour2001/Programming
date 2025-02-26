#include <iostream>
using namespace std;

// Function to swap two elements
void swap(char* a, char* b) {
    char temp = *a;
    *a = *b;
    *b = temp;
}

void reverse(char* arr, int start, int end){
    while (start < end){
        swap (&arr[start], &arr[end]);
        start ++;
        end --;
    }
}

bool nextPermutation(char * arr, int size){
    int i = size - 2; // -1 for index start at 0, -1 for nullptr

    // Step 1: Find the first index `i` such that arr[i] < arr[i + 1]
    while (i >= 0 && arr[i] >= arr[i+1]){
        i--;
    }

    if (i<0){
        return false; // no more permutations
    }
    
     // Step 2: Find the smallest element in the suffix greater than arr[i]
    int j = size -1;
    
    while (arr[j] <= arr[i])
    {
        j--;
    }
    
    // Step 3: Swap arr[i] and arr[j]
    swap(&arr[i], &arr[j]);

    // Step 4: Reverse the suffix starting at arr[i + 1]
    reverse(arr, i + 1, size - 1);

    return true; // Next permutation exists
}

int main() {
    char arr[] = "ABC"; // Input string
    int size = sizeof(arr) - 1; // Exclude null terminator

    // Generate permutations iteratively
    do {
        cout << arr << endl; // Print current permutation
    } while (nextPermutation(arr, size)); // Get the next permutation

    return 0;
}