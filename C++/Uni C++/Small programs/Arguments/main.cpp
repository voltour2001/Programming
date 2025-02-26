#include <iostream>

//! This program takes a command-line argument (e.g., a filename) 
//! and prints its characters one by one, each on a new line.

//* How to run
//? ->  g++ -o main main.cpp
//? ->  main test.txt

int main(int argc, char* argv[]) {
    if (argc > 1) {  // Check if there is at least one argument
        char* inputFilename = argv[1];  // "input.txt"
        
        std::cout << "The characters in '" << inputFilename << "' are:\n";
        for (int i = 0; inputFilename[i] != '\0'; i++) {  // Iterate until the null terminator
            std::cout << inputFilename[i] << '\n';  // Print each character on a new line
        }
    }

    return 0;
}