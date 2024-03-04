def decode_sorter(file):
    
    """	
    Summary:
        Decodes and sorts a file containing numbers and words.
    
    Param:
        The name of the file
    
    Returns:
    	A string containing the sorted message.
    """

    with open(file, 'r') as file:

        message_words = [] # A list of tuples (number, word)
        max_number = 0 # The maximum number in the file to create pyramid list of the right size
        
        
        
        # lines = A list, each element is a line in the file with \n
        lines = file.readlines() # Lines = ['3 love\n', '3 sun\n', ...]


        number = 0  # Number that will contain the number of each line
        word = ''   # Word that will contain the word of each line

        for line in lines:  # First Iteration =>   line = '3 love\n'
            
            # strip() =  Removes leading and trailing whitespaces (spaces, tabs, and newline characters)
            # split() =  Splits the string at the specified separator (default is whitespace(' ')) and returns a list of strings
            item = line.strip().split() # First Iteration =>    item = ['3', 'love']
            
            # Get the number(convert it to int) and the word from the list item
            number = int(item[0])
            word = item[1]
            
            # Keep track of the maximum number
            if number > max_number:
                max_number = number
                
            # Add the tuple (number, word) to the list of all the (number, word)
            message_words.append((number, word))
        
        
        
        # Create the pyramid with size = max_number (we start from 0)
        pyramid = ['' for i in range(0, max_number)] 
        
        for number, word in message_words:
            pyramid[number-1] = word # -1 because number starts from 1 but list starts from 0


        sorted_message = ' '.join(pyramid) # Join each element of the list with a ' '
    
    return sorted_message

def generate_pyramid_lines(message):

    words = message.split()
    pyramid = []
    index = 0

    while index < len(words):
        
        # Create a row to add to pyramid
        #to get the length we use index until index + previous row length + 1 to get new space because next row is +1
        row = words[index:index + len(pyramid) + 1]
        
        # Add the row to the pyramid
        pyramid.append(row)
        
        # Add the length of the row to the index
        index += len(row) # Also now has the length of the last used row so when we add them on line 67 + 1 we get the new extra space for the next sublist.

    return pyramid

    """
    
    Table to visualise what is going on:
                                                      (how many items)
    Iterations     |   pyramid          |   index    |   len(row)   |   words[index:index + len(pyramid) + 1]   |
    --------------------------------------------------------------------------------------------------------
    0              |   []               |   0        |   0          |   0                                       |
    1              |   [1]              |   1        |   1          |   [0 : (0+0+1)]   0:1                     |   
    2              |   [2,3]            |   3        |   2          |   [1 : (1+1+1)]   1:3                     |
    3              |   [4,5,6]          |   6        |   3          |   [2 : (2+2+1)]   3:6                     |
    4              |   [7,8,9,10]       |   10       |   4          |   [6 : (6+3+1)]   6:10                    |
    5              |   [11,12,13,14,15] |   15       |   5          |   [10 : (10+4+1)] 10:15                   |
    """
    

def last_items(pyramid):
    
    """
    Function to return the last item of each sublist in the pyramid

    Returns:
        
        A string containing the last item of each sublist in the pyramid    
    """
    
    decoded = ''
    
    for sublist in pyramid: # For each sublist in the pyramid

        decoded += sublist[-1] + ' ' # Add the last item of the sublist
        
    return decoded


#! THIS IS THE MAIN PROGRAM !#

message_file = '.\\Python\\Decode\\input.txt'

sorted_message = decode_sorter(message_file)

pyramid = generate_pyramid_lines(sorted_message)

#print(pyramid)

print(last_items(pyramid))






