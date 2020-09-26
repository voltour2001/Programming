import os
import webbrowser
import requests
from googlesearch import search 
import time

#location of my songs
maps = "C:\\Users\\spiros\\AppData\\Local\\osu!\\Songs"

#get the names of the songs in a list
list_of_songs = [i for i in os.listdir(maps)]

#pop the last one because it is my custom file
list_of_songs.pop()

#only names
list_of_songs_names = [i.split(" ",1)[1] for i in list_of_songs]

#make file to put the hyperlinks of the songs
file= open("C:\\Users\\spiros\\My_files\\VSCode\\Projects\\project2\\main.html", "w")
file.write("<html>\n<head></head>\n<body>\n<ol>\n\n")

# Take every song name & google search it. 
# Open the first link
# And put the link in the hyperlink with the according song name
for item in range(int(input("How many songs? :"))):

    t0 = time.time()# timer for each song

    query = list_of_songs[item]

    for song_url in search(query, tld="co.in", num=10, stop=1): 
        # Make the htlm file with the links
        file.write("<li><a href=")
        file.write(song_url)
        file.write(">")
        file.write(list_of_songs_names[list_of_songs.index(list_of_songs[item])])
        file.write("</a>\n")

    t1 = time.time()
    print("Time required: ", t1- t0)# 2.8 secs per song approx.

file.write("\n</ol>\n</body>\n</html>")
