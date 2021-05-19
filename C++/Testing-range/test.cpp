#include <iostream>
#include <vector>

void print_name(int x, std::string name){

    std::cout << "You have an ugly name, " << name << ", "<< x << " times uglier than average.";

}

int main() {

    print_name(5, "Spiros");

}   