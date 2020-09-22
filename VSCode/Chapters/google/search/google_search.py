from googlesearch import search 

query = "How to search query using python"
  
for j in search(query, tld="co.in", num=10, stop=5): 
    print(j) 