template <typename T>
class SparseMatrix {
protected:
    map<Coordinates, T> data;

public:
    // Add a method to iterate and print data

    void print()  const{
        for (const auto& [coord, value] : data){
            coord.print();
            cout << ": " << value << endl;
        }
    }

    void insert(unsigned int row, unsigned int col, const T& value){
        Coordinates coord = {row,col};
        data[coord] = value;
    }
};