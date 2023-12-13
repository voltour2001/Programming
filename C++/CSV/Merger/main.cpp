#include <iostream>
#include <fstream>
#include <string>
#include <unordered_map>

void mergeCSVFiles(const std::string& file1, const std::string& file2, const std::string& outputFile) {
    std::ifstream input1(file1);
    std::ifstream input2(file2);
    std::ofstream output(outputFile);

    std::string line;
    std::unordered_map<std::string, std::string> mergedData;

    // Read and write the header (first line) from the first input file
    std::getline(input1, line);
    output << line << std::endl;

    // Read and merge the remaining lines from the first input file
    while (std::getline(input1, line)) {
        std::string key = line.substr(0, line.find(','));
        mergedData[key] = line;
    }

    // Skip the header line of the second input file
    std::getline(input2, line);

    // Read and merge the lines from the second input file
    while (std::getline(input2, line)) {
        std::string key = line.substr(0, line.find(','));
        if (mergedData.find(key) != mergedData.end()) {
            // Merge conflict detected
            std::cout << "Merge conflict detected for key: " << key << std::endl;

            // Handle the merge conflict based on your requirements
            // Here, we are simply appending "_file2" to the conflicting line
            line += "_file2";
        }

        mergedData[key] = line;
    }

    // Write the merged data to the output file
    for (const auto& entry : mergedData) {
        output << entry.second << std::endl;
    }

    // Close the file streams
    input1.close();
    input2.close();
    output.close();

    std::cout << "CSV files merged successfully!" << std::endl;
}
int main() {
    std::string file1 = "file1.csv";
    std::string file2 = "file2.csv";
    std::string outputFile = "merged.csv";

    mergeCSVFiles(file1, file2, outputFile);

    return 0;
}