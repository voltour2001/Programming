#include <iostream>
#include <vector>
#include "functions.cpp"

int main(){
    std::vector<std::string> order = make_coffee(true, ); 
    std::cout << "\nThe Coffee Order is :\n----------------------------\n" << "      " << order[0] << "\n" << "      " << order[1] << "\n" << "      " << order[2] << "\n----------------------------"; 
}