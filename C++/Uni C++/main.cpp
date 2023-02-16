#include <iostream>
#include <string>
#include "main_utils.h"

using namespace std;
int main()
{
    int max_len = 5;

	cout << "Please enter string: ";	
	char* str = new char[max_len + 1];
	for (size_t i = 0; i != max_len; ++i)
	{
		cin >> str[i];

	}

	cout << "Entered string is:" << str << endl;
    
    //! CPP lecture 4
    //! Minute : 
    //todo charChanges('a');

    //todo cout << toUpperCase('g') << endl;

    return 0;
}

