#include <iostream>
#include "main_utils.h"

using namespace std;



// * Returns the Upper Case character of the user input 
char toUpperCase(char input){
    if (input >='a' && input <='z'){
        return input -32; // d = 100 , D = 68 in the ASCII code.
    }else{return input;}
}



void charChanges(char x){
                                                        //* ASCII for X
    cout << "Your Character Is: " << x << endl;         //* Prints the char
    
    x++;                                                //* Char + 1
    cout << "Your Character + 1 Is : " << x << endl;    //* Prints the char + 1 on the ASCII table
    

    cout << "Input a new Char : ";
    cin >> x;                                           //* Input "F". c = 70 (ASCII of F)
    cout << "Your New Char Is: " << x << endl;          //* Prints "F"

    //!  c = c + 5; Doing this will make it to ASCII 75 = "K" and then we can print c
    cout << "Your Char number on the ASCII Table Is: " << x + 0 << endl;    //* This prints Int of Char number on the ASCII table
                                                                             //* This doesn't work because the result of this addition will be int    
};