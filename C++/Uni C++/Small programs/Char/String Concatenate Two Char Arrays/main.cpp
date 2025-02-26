#include <iostream>

//! This program concatenates two C-style strings
// String 1: Hello, 
// String 2: World!
// Concatenated String: Hello, World!

void concatenateString(char * str1, char* str2, char* result){
    char * p1 = str1;
    char * p2 = str2;
    char * pRes = result;

    while (*p1 != '\0'){
        *pRes = *p1;
        p1++;
        pRes++;
    }

    while (*p2 != '\0') {
        *pRes = *p2;
        p2++;
        pRes++;
    }

    *pRes = '\0';
}

//! Custom way to get size of C-style string (char string)
int stringLength(char* str){
    char * p = str;
    int length = 0;

    while (*p != '\0'){
        length++;
        p++;
    }
    return length;
}

int main(){
    char str1[] = "Hello, ";
    char str2[] = "World!";

//* ================= 2 Ways to get size =================*//
    int size1 = stringLength(str1);
    int size2 = stringLength(str2);

    // int size1 = sizeof(str1)-1; 
    // int size2 = sizeof(str2)-1;

    //? -1 to remove '\0' at the end. 
    //? Program still works same without -1 but uses extra space
//* ================= 2 Ways to get size =================*//


    int resultSize = size1 + size2 + 1; 

    char * result = new char[resultSize];

    concatenateString(str1, str2, result);

    std::cout << "String 1: " << str1 << std::endl;
    std::cout << "String 2: " << str2 << std::endl;
    std::cout << "Concatenated String: " << result << std::endl;

    delete[] result; // Free dynamically allocated memory
    return 0;

}