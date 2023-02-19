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
    myFile.open("data.txt", ios::app); 
    if(myFile.is_open()){
        myFile << "Username\nPassword" << endl;
        myFile.close();
    }

}