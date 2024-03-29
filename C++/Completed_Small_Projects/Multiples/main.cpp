#include <iostream>
#include <cmath>
#include <vector>

// Function that returns a vector with the multiples
std::vector<int> multiples(int num, int mult){
    std::vector<int> Vector_multiple = {num};
    for(int i = 1; i <= mult; i++){
        Vector_multiple.push_back(num * i);
    }
    return Vector_multiple;
}


int main() {
    int number;
    int number_multiples;

    std::cout << "Type a number : ";
    std::cin >> number;
    
    std::cout << "How many multiples do you want : ";
    std::cin >> number_multiples;

//  Call multiple function and put the multiples on "array" 
    std::vector<int> array = multiples(number, number_multiples);

//  Outputs the multiples
    for (int i = 0; i < array.size(); i++){
        if (i==0){
            std::cout << "\nYour number is : " << number << "\n\n";
        }else if (i==1){
            std::cout << i <<"'st multiple"  << " : " << array[i] << "\n";
        }else if (i==2){
            std::cout << i <<"'nd multiple"  << " : " << array[i] << "\n";
        }else if (i==3){
            std::cout << i <<"'rd multiple"  << " : " << array[i] << "\n";
        }else if (i>3){
            std::cout << i <<"'th multiple"  << " : " << array[i] << "\n";
        }
    }
    std::cout << "\n";
    system("pause");
}   