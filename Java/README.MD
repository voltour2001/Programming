
Create Java Project

        CTRL + SHIFT + P

        >Java: Create Java Project



How to Compile & Run Command without Java Project:

    Current Directory:
        javac *.java & java -cp .. Project/Main

    Parent Directory:
        javac Project/*.java & java Project/Main






Example:

    Directory name = "Test"

    Two Java files by the names of "Main.java" & "Functions.java"

    To be able to run from main and also see the functions from the other file you need to run in the CMD if inside the directory:

        >> javac *.java & java -cp .. Test/Main
    
    Or if on the parent directory:
        
        >> javac Project/*.java & java Project/Main