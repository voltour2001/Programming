#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <vector>
#include <conio.h>

//? What Does This Program Do?
//? 
//?     This program reads data from a CSV file
//? 
//?     ==> Calculates the average age
//?     ==> Calculates the minimum and maximum age

//* Function to get the ages from the CSV file
std::vector<int> getAges(const std::string& filename) {

    //* Read data from CSV file
    std::ifstream file(filename);
    if (!file.is_open()) {
        std::cout << "Failed to open the file." << std::endl;
        return {};
    }

    //* Skip the header line
    std::string header;
    std::getline(file, header);

    std::string line;
    std::vector<int> ages;

    //* Extract the age from each line
    while (std::getline(file, line)) {
        std::istringstream iss(line); // Parse the line into steam named iss (Input String Stream)
        std::string item; 

        //* Extract the second item from each line (age)
        std::getline(iss, item, ','); // Get the first item from stream iss
        std::getline(iss, item, ','); // Get the Second item from stream iss

        int age = std::stoi(item); // String to int
        ages.push_back(age); // Add the age to the end of the vector
    }

    file.close();

    return ages;
}

//* Given File and Line Number return the whole line
std::string getLineFromCSV(const std::string& filename, int lineNumber) {
    std::ifstream file(filename);
    std::string line;
    
    std::string header;
    std::getline(file, header);

    int currentLine = 0;

    while (std::getline(file, line)) {
        currentLine++;
        if (currentLine == lineNumber) {
            file.close();
            return line;
        }
    }

    file.close();
    return ""; // Return an empty string if the desired line was not found
}

int main() {
    //* CSV File
    std::string filename = "data.csv";

    //* Get the ages from the CSV file
    std::vector<int> ages = getAges(filename); 

    //! Calculate the average age and store Min and Max (and Indexes)
    int counter = 1; // First is the header
    int minIndex = 1;
    int maxIndex = 0;
    int min =1000;
    int max = 0; 

    int sum = 0;
    for (int age : ages) {
        
        sum += age; // Add the age to the sum

        // Update the min and max (and indexes)
        if(age < min){ 
            min = age;
            minIndex = counter;
        }
        if(age > max){
            max = age;
            maxIndex = counter;
        }
        counter++;
    }
    
    // Calculate the average age
    double average = static_cast<double>(sum) / ages.size();


    // Print the Average age
    std::cout << "\n----------------------------------------------" << std::endl;
    std::cout << "              Average age: " << average << std::endl;
    std::cout << "----------------------------------------------" << std::endl;

    // Print the minimum and maximum ages
    std::cout << "To show Min and Max press 1: ";
    int input;
    std::cin >> input;
    std::cout << std::endl;

    if(input == 1){
        std::cout << "Youngest  : " << getLineFromCSV(filename, minIndex) << std::endl << std::endl;
        std::cout << "Oldest    : " << getLineFromCSV(filename, maxIndex) << std::endl << std::endl;
    }


    //* Wait for user to close the console
    std::cout << "Press any key to continue: ";
    _getch();

    return 0;
}