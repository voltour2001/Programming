#include <iostream>
#include <vector>

int main(){
    bool done = false;
    std::vector<int> num;
    std::cout << "\nAdd numbers to the list or enter end/done/finished or just enter \"0\"\n\n";

    int temp = 1;

    while (done==false){
        std::cout << "Add: ";
        std::cin >> temp;
        if (temp==0){
            done=true;
        }else{
            num.push_back(temp);
        }
    }

    int even_num = 0;
    int odd_prod = 1;

    for (int i = 0; i < num.size(); i++){
        if(num[i]% 2 == 0){
            even_num = even_num + num[i];
        }else{
            odd_prod = odd_prod * num[i];
        }
    }

    std::cout << "\nThe sum of all the even numbers are : " << even_num << "\n";
    std::cout << "The prod of all the odd numbers are : " << odd_prod << "\n";
    system("pause");
}
