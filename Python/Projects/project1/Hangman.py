import random
import time

# Initial Steps to invite in the game:

print("\nWelcome to Hangman Game by Spyros\n")
name = input("Enter your name: ")
print("Hello",name+"! Best of Luck!\n")
time.sleep(2)
print("This game is about to start!\nLets play Hangman!")
time.sleep(3)

def main():
    global count
    global display
    global word
    global already_guessed
    global length
    global play_game
    WordsToGuess = ["january","border","image","film","promise","kids","lungs","doll","rhyme","damage","plants"]
    word = random.choice(WordsToGuess)
    length = len(word)
    count = 0
    display= '_' * length
    already_guessed = []
    play_game = ""