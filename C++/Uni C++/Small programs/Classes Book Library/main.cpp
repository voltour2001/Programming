#include <iostream>
#include <string>
using namespace std;

class Book {
private:
    string title;
    string author;
    unsigned short year;
    unsigned int numCopies;

public:
    Book(const string& bookTitle, const string& bookAuthor, unsigned short year, unsigned int copies)
        :title(bookTitle), author(bookAuthor), year(year), numCopies(copies) {
    }
    void display();
    string getTitle() {
        return title;
    }
};

void Book::display(){
    cout << "Title: " << title << ", Author: " << author
        << ", Year: " << year << ", Copies: " << numCopies << endl;
}

class Library {
private:
    Book** books;
    unsigned int size;      // number of books in library
    unsigned int capacity;  // max capacity of array


    void resize() {
        unsigned int newCapacity = capacity * 2;
        Book** newBooks = new Book * [newCapacity];

        // Copy to new array
        for (size_t i = 0; i < size; i++)
        {
            newBooks[i] = books[i];
        }

        // delete old array and update pointer
        delete[] books;
        books = newBooks;
        capacity = newCapacity;
    }


public:
    Library() : books(new Book*[2]), size(0), capacity(2){}

    ~Library() {
        for (size_t i = 0; i < size; i++)
        {
            delete books[i]; // free memory for each book
        }
        delete[] books;
        cout << "Memory for books cleared" << endl;
    }

    void addBook(const string& title, const string& author, unsigned short year, unsigned int copies) {
        if (size == capacity)
        {
            resize();
        }
        books[size++] = new Book(title, author, year, copies);
    }

    void displayBooks() {
        if (size == 0) {
            cout << "\nThe library is empty!\n" << endl;
            return;
        }

        cout << "\nBooks in library: \n" << endl;
        for (size_t i = 0; i < size; i++)
        {
            books[i]->display();
        }
    }


    void removeBook(const string& title) {
        for (size_t i = 0; i < size; i++)
        {   
            if (books[i]->getTitle() == title)
            {   
                delete books[i];
            }
            for (size_t j = i; j < size - 1; ++j) {
                books[j] = books[j + 1];
            }

            size--;
            cout << "Book titled \"" << title << "\" has been removed from library" << endl;
            return;
        }
        cout << "Book titled \"" << title << "\" not found in the library." << endl;
    }
};



int main() {

    Library library;

    library.displayBooks();

    // Add some books to the library
    library.addBook("1984", "George Orwell", 1949, 5);
    library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, 3);
    library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 2);

    library.displayBooks();

    // Remove a book by title
    cout << "\nRemoving '1984' from the library..." << endl;
    library.removeBook("1984");

    library.displayBooks();

    return 0;
}
