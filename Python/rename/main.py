import os

directory_path = os.path.dirname(os.path.abspath(__file__))

for filename in os.listdir(directory_path):
    if filename.startswith('.'):  # Skip hidden files
        continue

    parts = filename.split('_')
    if len(parts) > 2:
        parts[1] = 'base'
        new_filename = '_'.join(parts)
        os.rename(os.path.join(directory_path, filename), os.path.join(directory_path, new_filename))
        
        
        
