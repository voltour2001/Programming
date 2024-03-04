
    
import os

directory_path = os.path.dirname(os.path.abspath(__file__))
word_to_replace = 'skin40'

for filename in os.listdir(directory_path):
    if filename.startswith('.'):
        continue
    new_filename = filename.replace(word_to_replace, 'base')
    os.rename(os.path.join(directory_path, filename), os.path.join(directory_path, new_filename))



