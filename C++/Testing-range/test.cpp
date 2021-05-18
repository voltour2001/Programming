#include <iostream>
#include <vector>

int main() {
    std::vector<std::string> dna = {"ATG", "ACG"};
    dna.push_back("ABC", "DEF");
    std::cout << dna[3];
}