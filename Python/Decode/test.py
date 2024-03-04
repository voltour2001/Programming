def read_file(file_path):
    with open(file_path, 'r') as file:
        lines = file.readlines()
    return lines

def sort_and_combine(lines):
    items = [line.strip().split(' ') for line in lines]
    sorted_items = sorted(items, key=lambda x: int(x[0]))
    sentence = ' '.join(item[1] for item in sorted_items)
    return sentence

def create_pyramid(sentence):
    words = sentence.split()
    pyramid = []
    index = 0

    while index < len(words):
        row = words[index:index + len(pyramid) + 1]
        pyramid.append(row)
        index += len(row)

    return pyramid

def print_pyramid(pyramid):
    for row in pyramid:
        print(' '.join(row))

if __name__ == "__main__":
    file_path = ".\\Python\\Decode\\input.txt"  # Replace with the path to your txt file
    lines = read_file(file_path)

    sentence = sort_and_combine(lines)
    pyramid = create_pyramid(sentence)
    print_pyramid(pyramid)
