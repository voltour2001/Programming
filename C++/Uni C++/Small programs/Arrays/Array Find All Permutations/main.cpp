#include <iostream>

using namespace std;

void swap(char * a, char * b){
    char temp = *a;
    *a = *b;
    *b = temp;
}


void printPermutations(char * arr, int start, int end){

    char * p = arr;

    if (start == end){
        cout << arr << endl; 
        return;
    }

    for (size_t i = start; i <= end; i++)
    {
        swap((arr+start), (arr+i));
        printPermutations(arr, start + 1, end);
        swap((arr+start), (arr+i));
    }
    
}



int main(){
    char ar[] = "ABC";
    int size = sizeof(ar)-1;

    printPermutations(ar, 0, size-1);

    return 0;
}