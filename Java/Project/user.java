package Project;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Handles the file users.txt
 * 
 * Takes Arguments AFM and check if the user has been registered and if not to register them
 * Registered users are stored in users.txt
 * 
 */

public class user {
    public static void userCheck(int AFM){

        boolean found = false; // If we have found match to AFM "found"=true

        //! Reader
        //* Reads every AFM per line to see if it is already added. IF it is prints it.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./files/users.txt"));
            String line;
            
            int i=1; // Keeps track how many lines and on what line we are right now

            //* Reads every line to check if AFM 
            while ((line = reader.readLine()) != null && found != true) {

                int number = Integer.parseInt(line); // String Line -> Int Line

                //* If we find AFM print line and stop loop
                if (number == AFM){
                    System.out.println("User Found");
                    found = true;
                }
                i++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    
        //! Writer
        //* If AFM hasn't been found in file means new user and registers/adds AFM to users.txt 
        if(found==false){
            try {
                FileWriter writer = new FileWriter("./files/users.txt", true);
                writer.write(Integer.toString(AFM) + "\n");
                writer.close();
                System.out.println("Added user");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }

    }
}
