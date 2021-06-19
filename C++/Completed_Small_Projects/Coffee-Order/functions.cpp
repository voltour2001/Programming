#include <string>
#include <vector>

std::vector<std::string> make_coffee(bool milk, int sugar_cube = 0, bool cookie = false){
    
    std::vector<std::string> coffee;

    // Milk
    if (milk == true){
        coffee.push_back("Add Milk");
    }else{
        coffee.push_back("No Milk");
    }

    // Sugar Cubes
    std::string cubes;
    if (sugar_cube == true or sugar_cube == false){
        goto skip;
    }
    if (sugar_cube == 1){                                                                       // Random variable to add (blend) everything togethere.
        cubes = "Put " + std::to_string(sugar_cube) + " Sugar Cube";              // Turn int "sugar_cubes" to a string to add that number to a sentence.
        coffee.push_back(cubes);
    }else if (sugar_cube > 1){
        cubes = "Put " + std::to_string(sugar_cube) + " Sugar Cubes";
        coffee.push_back(cubes);
    }else{
        cubes = "No Sugar Cubes";
        coffee.push_back(cubes);
    }

    // Cookie
    skip: 
    if (cookie == true){
        coffee.push_back("And a Cookie");
    }

    return coffee;

}