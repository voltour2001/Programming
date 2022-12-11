#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;


int Avaliable(string Room_type, vector<int> Room_status){
    if (Room_type == "Single"){
        for (int i = 0; i < 5; i++){
            if (Room_status[i]==0){
                cout << "we found a Single room, the number is " << i << endl;
                return i;
                break;
            }else if (i == 4){
                cout << "I am sorry we are full\n";
                break;
                }
        }
    }else if (Room_type == "Twin"){
        for (int i = 5; i < 10; i++){
            if (Room_status[i]==0){
                cout << "we found a Twin room, the number is " << i << endl;
                return i;
                break;
            }else if (i == 9){
                cout << "I am sorry we are full\n";
                break;
            }                
        }
    }else if (Room_type == "Double"){
        for (int i = 10; i <= 30; i++){
            if (Room_status[i]==0){
                cout << "we found a room, the number is " << i << endl;
                return i;
                break;
            }else if (i == 29){
                cout << "I am sorry we are full\n";
                break;
            }
        }
    }
}


