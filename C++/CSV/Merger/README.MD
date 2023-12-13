This is a program that Merges two CSV files

Given the two files it merges them into the "merged.csv" and
Checks if any duplicates exists and adds "_file2"

Right now it is only possible to detect duplicates from the two different
files, or when the duplicates lines exists in the second file.

eg:

    file1:
    Name,Age,City
    John,25,New York
    Sarah,35,San Francisco

    file2:
    Name,Age,City
    Sarah,35,San Francisco
    Michael,28,Boston

    ===> Merged:

    Sarah,35,San Francisco_file2

eg2:

    file1:
    Name,Age,City
    John,25,New York
    Michael,28,Boston

    file2:
    Name,Age,City
    Sarah,35,San Francisco
    Sarah,35,San Francisco


    ===> Merged:
    ...
    ...
    Sarah,35,San Francisco_file2