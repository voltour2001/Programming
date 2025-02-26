#include <iostream>
#include <string>
using namespace std;

//* Sum of Even Numbers
//* calculate the sum of all even numbers from 2 up to and including n.

int EvenSum(int & n){
    int sum = 0;
    for (int i = 2; i <= n; i+= 2){
        sum += i;
    }
    return sum;
}

int main(){
    
    cout << "Number: ";
    int input; cin >> input;

    int sum = EvenSum(input);

    cout << "Sum of even numbers up to " << input << " is: " << sum << endl;
    return 0;
}