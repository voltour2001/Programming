import os
import webbrowser
import requests
from googlesearch import search 
import time
from flask import Flask, redirect, url_for, render_template, request, flash, session

#===> Osu songs finder <===#

maps = "C:\\Users\\spiros\\AppData\\Local\\osu!\\Songs" #location of my songs

list_of_songs = [i for i in os.listdir(maps)] #get the names of the songs in a list
list_of_songs.pop() #pop the last one because it is my custom file

list_of_songs_names = [i.split(" ",1)[1] for i in list_of_songs] #only names, remove the numbers in the start of each song

#===> Webpage <===#


app = Flask(__name__)
@app.route("/")
def home():
    return render_template("home.html", content="Testing")

@app.route("/songs")
def songs():
    return render_template("songs.html", content="Songs")

@app.route("/songs" , methods=["POST"])
def my_form_post():
    number_of_songs = request.form["SN"]
    son=[]
    for i in range(int(number_of_songs)):
        query = list_of_songs[i]
        for song_url in search(query, tld="co.in", num=10, stop=1):
            son.append(song_url)

    return render_template("songs_result.html", content="Songs",lis=son, lis_of_songs=list_of_songs_names)


@app.route("/Pinfo")
def Pinfo():
    return render_template("Pinfo.html", content="Pinfo")


@app.route("/Sinfo")
def Sinfo():
    return render_template("Sinfo.html", content="Sinfo")


if __name__== "__main__":
    app.run(debug=True)

