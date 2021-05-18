#include <iostream>
#include <vector>

int main(){

    std::vector<int> num = {2, 4, 3, 6, 1, 9};

    int even_num = 0;
    int odd_prod = 1;

    for (int i = 0; i < num.size(); i++){
        if(num[i]% 2 == 0){
            even_num = even_num + num[i];
        }else{
            odd_prod = odd_prod * num[i];
        }
    }

    std::cout << even_num << "\n";
    std::cout << odd_prod << "\n";
}
