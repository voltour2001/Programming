#include <iostream>

//! Prints the reverse of C-style string (char)
// Original String: Spiros!
// Reversed String: !soripS

void reverseString(char * str, int size){

    char * start = str;
    char * end = str + size-1;
    // str[size] index begins with 0 so we need another -1 to get last element

    while(start < end){
        char temp = *start;
        *start = *end;
        *end = temp;

        start++;
        end--;
    }

}

int main(){
    char str[] = "Spiros!";
    
    // sizeof(str) = return 7 + 1 (nullptr)
    int size = sizeof(str)-1; // -1 to remove nullptr
    
    std::cout << "Original String: "<< str << std::endl;

    reverseString(str, size); // Reverse C-style string

    std::cout << "Reversed String: " << str << std::endl;
}