#include <iostream>
using namespace std;


void print(int a) {
    cout << "|" << a << "|";
}

void replicate(void (*p_func)(int), int data, int times) {

    for (int i = 0; i < times; i++)
    {
        p_func(data);
    }

}

int main() {

    void (*p_func)(int);

    p_func = print;

    replicate(p_func, 10, 20);


    return 0;
}