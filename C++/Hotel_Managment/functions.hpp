#include <iostream>
#include <vector>

using namespace std;

int Avaliable_rooms();//shows avaliable rooms.

vector<string> Room_info(int room);//returns the rooms info along with the person that is staying there, if any.

//This is finished
int Avaliable(string Room_type, vector<int> Room_status);//check the status of a room

void Change_status();//change the status of a room

int Warning();//adds a warning to the customer, if customer reaches 3 warning he will be evicted.

