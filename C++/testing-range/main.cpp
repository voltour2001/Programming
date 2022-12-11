#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>

using namespace std;

int main()
{
  int x;
  cout << "Hello World!" << '\n';
  cout << "Please input a number" << '\n';
  std::cin >> x;
  for (size_t i = 0; i < x; i++){
    std::cout << "fuck" << '\n';
  }
  return 0;
}