#include <iostream>
using namespace std;

//! Show the index and value with one decimal place

// Prints like this
//  0.5     ->    sequence[0] = 0.5
//  1       ->    sequence[1] = 1.0
//  1.5     ->    sequence[2] = 1.5
//  2       ->    sequence[3] = 2.0
//  2.5     ->    sequence[4] = 2.5


float * newArr(int size){
    float * data = new float[size];
    for(int i = 0; i<size; i++)
        data[i] = (i+1)/2.0;
    return data;
}

int main(){
    int meg = 5;

    float * sequence = newArr(meg);

    for (int i = 0; i < meg; i++) {

        // cout << sequence[i] << endl;
        printf("sequence[%d] = %0.1f\n", i, sequence[i]);
    
    }

}