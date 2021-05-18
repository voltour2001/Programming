#include <iostream>
#include <vector>

int main() {
    
    std::vector<int> num = {0, 10, 20};

    for (int i = 0; i < num.size(); i++) {
    
    num[i] = num[i] + 10;
    
    }
    for (int i = 0; i < num.size(); i++){
        std::cout << num[i] << "\n";
    }
}