#include <iostream>


using namespace std;

void printSum(int * arr, int rows, int cols){
    for (int i = 0; i < rows; i++)
    {
        int sum = 0;

        for (int j = 0; j < cols; j++)
        {
            sum += *(arr + i * cols + j);
        }
        cout << "Sum of row " << i << ": " << sum << endl;
        
    }
    
}

int main(){
    
    //? ================================ Static ================================ ?//

    // int matrix[4][3] = {
    // {1, 2, 3},
    // {4, 5, 6},
    // {7, 8, 9},
    // {10, 11, 12}
    // };

    // int * parr = *matrix;
    // printSum(parr, 4,3);


    //? ================================ Static ================================ ?//
    
    
    
    
    //? ================================ Dyn ================================ ?//

    int rows = 4;
    int cols = 3;

    //! Dynamically allocate 2D array
    int ** matrix = new int*[rows]; 
    
    
    // {
    // {},
    // {},
    // {},
    // {}
    // }

    for (int i = 0; i < rows; i++)
    {
        matrix[i] = new int[cols];
    }
    // {
    // {[],[],[]},
    // {[],[],[]},
    // {[],[],[]},
    // {[],[],[]}
    // }

    //! Initialize values
    int val = 1;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            matrix[i][j] = val++;
        }
        
    }


    int * flatMatrix = new int[rows * cols];

    //! Fill the 1D array with values from the 2D array
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            *(flatMatrix + i * cols + j) = matrix[i][j];
        }
    }

    printSum(flatMatrix, rows, cols);

}