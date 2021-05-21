#include <iostream>
#include <cmath>
#include <vector>

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

    std::vector<int> array = multiples(number, number_multiples);
    for (int i = 0; i < array.size(); i++){
        if (i==0){
            std::cout << "Your number is : " << number << "\n";
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
}   