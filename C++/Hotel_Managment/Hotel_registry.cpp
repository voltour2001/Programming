#include <iostream>
#include <vector>
#include "functions.hpp"

using namespace std;

    

int main() {
    
    /* About Rooms
        [0-4] = single rooms        total : 5
        [5-9] = twin rooms          total : 5
        [10-29] = double rooms      total : 20
    */
   /*
   //Create 30 Rooms. (0 = unocuppied. 1 = occupied)
    vector<int> Room_status;
    for (int i = 0; i < 30; i++){
        Room_status.push_back(0);
    }
    
    //Asking for what kind of room the customer wants
    
    string answer;
    cout << "\nWhat type of Room would you like.\n";
    cout << "We have Single, Twin, Double. If you would like info about the rooms enter \"info\"\n: ";
    cin >> answer;
    

    //If the customer wants info about the types of rooms
    if (answer == "info"){
        cout << "\nSingle: A single room has one single bed for single occupancy.\nTwin: A twin room has two single beds for double occupancy.\nDouble: A double room has one double bed for double occupancy."<< endl<<endl;
        cout << "What kind of Room would you like?\n: ";   
        cin >> answer;             
    } 

    //Check to see if a room is avaliable using Avaliable().
    if (answer == "Single"){
        int room = Avaliable(answer, Room_status);
    }else if (answer == "Twin"){
        int room = Avaliable(answer, Room_status);
    }else if (answer == "Double"){
        int room = Avaliable(answer, Room_status);
    }else{
        cout << "Invalid answer" << endl;
    }
*/

    //Info about customer

    string name;
    string phone;
    string gmail;

    cout << "Your name : ";
    cin >> name;
    cout << "Your phone number : ";
    cin >> phone;








}