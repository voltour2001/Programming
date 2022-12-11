#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>

using namespace std;

int main()
{
  int x;
  cout << "Hello World!" << '\n';
  std::cout << "Enter your grade : ";
  std::cin >> x;
  if (x<10) {
    std::cout << "you have failed" << '\n';
  }
  else{
    std::cout << "you passed with : " << x << '\n';
  }
  return 0;
}
