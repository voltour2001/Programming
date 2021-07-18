import os
import time


#========= Intro =========#

print("This is an introductory program on python's interactive help\n")

os.system("pause")  # Press any key to continue . . . 
os.system("cls")    # When pressed any key clear the screen

#========= dir() =========#

print("First we will take a look at dir\n")

time.sleep(2)

print("If you print dir() python displays a list of avaliable objects\n")
print(dir(),"\n\n") # Short for directory

os.system("pause")  # Press any key to continue . . . 
os.system("cls")    # When pressed any key clear the screen


print   ("""We will focous on __builtins__
            \nThis is a module that contains a collection of common object that is always avaliable for you.\n
        """)

time.sleep(2)

print("dir(__builtins__)\n")
print(dir(__builtins__),"\n\n")

os.system("pause")  # Press any key to continue . . . 
os.system("cls")    # When pressed any key clear the screen

#========= help() =========#

print("To learn about these object you call the help() function.\n")

time.sleep(3)

print("For example lets say you want to learn more about the pow() function\n")

time.sleep(3)

print("help(pow)\n")
print(help(pow), "\n\n")

os.system("pause")  # Press any key to continue . . . 
os.system("cls")    # When pressed any key clear the screen

#========= help('modules') =========#

print("Think of module as a folder that contains other python objects\n")

time.sleep(1)

print("To see a list of avaliable modules call help('modules')\n")

time.sleep(2)

print("help('modules')\n")
print(help('modules'), "\n")

os.system("pause")  # Press any key to continue . . . 
os.system("cls")    # When pressed any key clear the screen

print("To learn about a module and see what objects are available you must import it\n")
time.sleep(2)

print("Without importing for example math, dir() looks like this:\n")
print(dir(), "\n")

import math
print("After importing math, dir looks like this:\n")
print(dir(), "\n")
print("And it is ready to use.\n\nThen you can continue with dir(math) to see the objects avaliable in math.\nAnd use help() to learn more about a specific object \nexample: help(math.radians)\n")

os.system("pause")  # Press any key to continue . . . 
os.system("cls")    # When pressed any key clear the screen
