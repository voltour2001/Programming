#include <iostream>
#include <string>

using namespace std;
int main() {

    char s[] = "Spiros";

    void * ps = s;

        int b = *((int*)ps);

    cout << b << endl;
    return 0;
}