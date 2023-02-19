#include <iostream>
#include <fstream>

using namespace std;

int main(){

fstream myFile;
/* 
Write mode  = ios::out
Append Mode = ios::app
Read Mode   = ios::in 
*/
myFile.open("data.txt", ios::out); 
if(myFile.is_open()){
    myFile << "Username\nPassword" << endl;
    myFile.close();
}

myFile.open("data.txt", ios::in); 
if(myFile.is_open()){
    string line;
    while (getline(myFile, line)){
            std::cout << line << std::endl;
    }
    myFile.close();
}

}