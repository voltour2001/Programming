#include <iostream>
#include <climits>

using namespace std;
int main()
{
    char c1 = 'M';  //  If ASCII, saved as value 77 of ASCII table thus
    char c2 = 77;   //  c1, c2 Have the same value.
    char c3 = '\n';  //  Char for change line

    std::cout << c1 << " " << c2 << " " << std::endl;
    return 0;
}