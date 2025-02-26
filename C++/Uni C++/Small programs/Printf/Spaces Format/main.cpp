#include <iostream>

//! Format using prinf

// Car model: Tesla Model S
// Year:      2023

int main() {
    char carModel[] = "Tesla Model S";
    int year = 2023;

    // Manually calculate label lengths
    const char label1[] = "Car model:";
    const char label2[] = "Year:";

    int lengthLabel1 = sizeof(label1) - 1; // Subtract 1 for null terminator
    int lengthLabel2 = sizeof(label2) - 1;

    // Find the maximum label length
    int max = (lengthLabel1 > lengthLabel2) ? lengthLabel1 : lengthLabel2;


//\ (%-*s)
//\ - : align left
//\ * : Create a "field" of empty spaces size max.
//\ s : Adds the string inside the field

//\ (how it prints)
//\ prints label1/2
//\ if label1/2 is shorter than max then fill rest with spaces
//\ after field add second string 

    
    printf("%-*s %s\n", max, label1, carModel);
    printf("%-*s %d\n", max, label2, year);

// Steps
//  "___________" size max empty spaces
//  "label2_____"
//  "label2_____year"
//  "Year:      2023"
    return 0;
}