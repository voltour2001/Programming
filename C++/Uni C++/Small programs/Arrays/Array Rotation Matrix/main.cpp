#include <iostream>
using namespace std;

void rotateMatrix( int* matrix, int n){
    for (int layer = 0; layer < n/2; layer++)
    {
        int first = layer;
        int last = n - 1 - layer;

        for (int i = first; i < last; i++)
        {
            int offset = i - first;

            // Save the top element
            int top = *(matrix + first * n + i);

            // Move left to top
            *(matrix + first * n + i) = *(matrix + (last - offset) * n + first);

            // Move bottom to left
            *(matrix + (last - offset) * n + first) = *(matrix + last * n + (last - offset));

            // Move right to bottom
            *(matrix + last * n + (last - offset)) = *(matrix + i * n + last);

            // Move top to right
            *(matrix + i * n + last) = top;
        }
    }
}


// Function to print the matrix
void printMatrix(int* matrix, int n) {

    // Turns 2d matrix
    // {
    // {1,  2,  3},
    // {4,  5,  6},
    // {7,  8,  9}
    // }

    // Into 1d
    // {1, 2, 3, 4, 5, 6, 7, 8, 9};

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << *(matrix + i * n + j) << " ";
        }
        cout << endl;
    }
}


int main() {
    int n = 3; // Size 
    int matrix[3][3] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };


    cout << "Original Matrix:" << endl;
    printMatrix((int*)matrix, n);

    rotateMatrix((int*)matrix, n);

    cout << "Rotated Matrix:" << endl;
    printMatrix((int*)matrix, n);

    return 0;
}