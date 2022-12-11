#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <string>

using namespace std;

int main()
{
  string name = "Spyros";
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
  int i = 100;
  /* this is a comment */
  for (int i = 0; i < 3; i++)
  {
    cout << name << endl;
  }
  

  
  /* Another Comment */
  return 0;
}
