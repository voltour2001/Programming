# Decode and Sort File

This function decodes and sorts a file containing numbers and words. It reads the file, extracts the numbers and words from each line, and creates a pyramid list where each number is the index of a word in the list. 
Finally, it returns a string containing the end word of each pyramid line.

## Usage

```python
from decode_sorter import decode_and_sort_file

file_name = "path/to/file.txt"  # Replace with the path to your file
sorted_message = decode_and_sort_file(file_name)
print(sorted_message)