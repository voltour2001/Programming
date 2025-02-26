#include <iostream>

/*
!   =========>   Move Semantics    <=========

* Move: Transfers ownership of resources from one object to another without copying.

* Why move over copy
* Faster and more efficient for large or dynamic objects, as it avoids costly deep copies.
*/

static int moveCount; // Tracks the number of moves
static int copyCount; // Static counter for copy operations

class Example {
private:
    char* data;

public:

    // Constructor
    Example(const char* str) {
        int length = 0;
        while (str[length] != '\0') ++length; // Get string length
        data = new char[length + 1];
        for (int i = 0; i < length; ++i) {
            data[i] = str[i];
        }
        data[length] = '\0';
    }

    // Copy Constructor
    Example(const Example& other) {
        ++copyCount; // Increment the copy counter
        int length = 0;
        while (other.data[length] != '\0') ++length; // Get string length
        data = new char[length + 1];
        for (int i = 0; i < length; ++i) {
            data[i] = other.data[i];
        }
        data[length] = '\0';
    }

    // Move Constructor
    Example(Example&& other) noexcept : data(other.data) {
        ++moveCount;          // Increment the move counter
        other.data = nullptr; // Nullify the moved-from object's data
    }

    // Destructor
    ~Example() {
        delete[] data;
    }

    // Print function
    void print() const {
        if (data) {
            std::cout << data << '\n'; // Print the data
        }
        else {
            std::cout << "Moved-from\n"; // Indicate moved-from object
        }
    }
};



int main() {
    Example e1("Hello");        // Constructor
    Example e2 = e1;            // Copy constructor called
    Example e3 = std::move(e1); // Move constructor called again

    e1.print();                // Print "Hello"
    e2.print();                // Print "Hello"
    e3.print();                // Print "Hello"

    std::cout << "Number of copies: " << copyCount << std::endl;
    std::cout << "Number of moves: " << moveCount << std::endl;

    return 0;
}
