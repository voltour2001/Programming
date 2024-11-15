#include <iostream>
#include <string>

using namespace std;
int main() {
    int a = 5;

    int * pa = &a;

    *pa += 1;    
    std::cout << *pa << std::endl;


    return 0;
}