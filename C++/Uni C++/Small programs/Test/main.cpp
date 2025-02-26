#include <map>
#include <iostream>
#include "SparseMatrix.h"
using namespace std;

struct Coordinates {
    unsigned int row; // Zero-based row.
    unsigned int col; // Zero-based column.

    // Method to print the coordinates
    void print() const {
        cout << "(" << row << ", " << col << ")";
    }

    // Comparison operators to use Coordinates as map keys
    bool operator<(const Coordinates& other) const {
        return (row < other.row) || (row == other.row && col < other.col);
    }
};

int main(){
    map<Coordinates, int> data;
    data[{0,1}] = 10;
    data[{2,3}] = 20;

    for (const auto& [coord, value] : data) {
        coord.print(); // Print the coordinates
        cout << ": " << value << endl; // Print the value
    }
}
