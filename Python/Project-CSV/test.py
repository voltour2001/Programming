import csv

#========== reader ==========#

def Test_reader(target_file):
        
    with open(target_file, newline='') as csvfile:
    
        spamreader = csv.reader(csvfile, delimiter='\t')
    
        for row in spamreader:
            print(', '.join(row))
            
#========== writer ==========#
def test_writer(target_file, message):

    with open(target_file, 'w', newline='') as csvfile:

        
        spamwriter = csv.writer(csvfile, delimiter=' ', quotechar='|')
        spamwriter.writerow(['Spam'] * 5 + ['Baked Beans'])
        spamwriter.writerow(['Spam', 'Lovely Spam', 'Wonderful Spam'])

#========== DictReader ==========#

def Test_DictReader(target_file, dict_id):

    # 'first_name' will be the dictionary's first row ID
    fieldnames = ['first_name', 'last_name', 'email']

    with open(target_file, "r", newline='') as csvfile:
        
        spamreader = csv.DictReader(csvfile,fieldnames=fieldnames)

        for row in spamreader:
            print(row[dict_id])

#========== DictWriter ==========#

def Test_DictWriter(target_file, message=None):

    with open(target_file, "w",) as new_file:

        fieldnames = ['first_name', 'last_name', 'email']

        csv_writer = csv.DictWriter(new_file, fieldnames=fieldnames, delimiter="\t")

        csv_writer.writeheader()
        csv_writer.writerow({'first_name': 'Baked', 'last_name': 'Beans', 'email': 'ksnolaxt@gmail.com'})
        csv_writer.writerow({'first_name': 'Wonderful', 'last_name': 'Spam', 'email': 'bah10ky@gmail.com'})

#==========  ==========#

#==========  ==========#

#==========  ==========#


print(Test_reader("names.csv"))
print(Test_DictReader("names.csv","email"))

test_writer()