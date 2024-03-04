package bank;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class func {
    public static void main(String[] args) {
        Login login = new Login();
        Register register = new Register();

    }


class Login{
    public static List<String> login(){

        //* Variables *//
        Scanner scanner = new Scanner(System.in);
        List<String> credentials = new ArrayList<>();
        String username,password;
        boolean fileExists = false;

        //* UI *//
        System.out.println("===> LOGIN <===");
        System.out.print("Username (lowercase): ");
        String userName = scanner.nextLine();
        
        System.out.print("Password: ");
        String userPassword = scanner.nextLine();
        
        String lowerCaseUserName = userName.toLowerCase();
        
        
        //* Check if user already exists *//
        File directory = new File("./users/");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // If the file exists break the loop
                if (file.isFile() && file.getName().toLowerCase().equals(lowerCaseUserName + ".txt")) { 
                    fileExists = true;
                    break;
                }
            }
        }

        //* If user does not exist *//
        if (fileExists == false) {
            System.out.println("\n\n===> User does not exist <===");
            outerloop:
            while (true) {
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        List<String> cred = Login.login();
                        break outerloop;
                    case 2:
                        Register reg = new Register();
                        reg.register();
                        break outerloop                                 ;
                    case 3:
                        System.exit(0);

                }
            }
        }
        //* Open reader and store name and password to variable credentials *//
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./users" + File.separator + lowerCaseUserName + ".txt"));
            String firstLine = reader.readLine();
            if (firstLine.equals(userPassword)) {
                System.out.println("Login successful");
                credentials.add(lowerCaseUserName);
                credentials.add(userPassword);
            }
            reader.close();
        } catch (IOException e) {
        }
        return credentials;
    }
}

class Register{
    public void register(){
        Scanner scanner = new Scanner(System.in);
        
        String username,password;
        
        System.out.println("===> REGISTER <===");
        System.out.print("Username (lowercase): ");
        String userName = scanner.nextLine();
        
        System.out.print("Password: ");
        String userPassword = scanner.nextLine();
        
        
        //! Check if user already exists
        String lowerCaseUserName = userName.toLowerCase();
        boolean fileExists = false;
        
        File directory = new File("./users/");
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                // If the file exists break the loop
                if (file.isFile() && file.getName().toLowerCase().equals(lowerCaseUserName + ".txt")) { 
                    fileExists = true;
                    break;
                }
            }
        }
        
        if (fileExists == true) {
            System.out.println("File for user " + lowerCaseUserName + " already exists.");
        } else {
            // If file does not exist, create it and write the password
            try {
                FileWriter writer = new FileWriter("./users" + File.separator + lowerCaseUserName + ".txt");
                writer.write(userPassword);
                writer.close();
                System.out.println("File created for user " + lowerCaseUserName + ".");
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }     
    }
}


class Transfer{

}

class UniqueIdentifierGenerator{
    // Directory path where the text files are located
    String directoryPath = "path/to/your/directory";

    // Get a list of files in the directory
    File directory = new File(directoryPath);
    File[] files = directory.listFiles();

    // Create a map to store file names and their unique identifiers
    Map<String, String> fileIdentifiers = new HashMap<>();

    // Generate unique identifiers for each file
    if (files != null) {
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                String identifier = generateIdentifier(file.getName());
                fileIdentifiers.put(file.getName(), identifier);
            }
        }
    }

    // Print the mapping of file names to identifiers
    for (Map.Entry<String, String> entry : fileIdentifiers.entrySet()) {
        System.out.println("File: " + entry.getKey() + ", Identifier: " + entry.getValue());
    }
}

private static String generateIdentifier(String fileName) {
    // Use hashCode() to generate a hash code from the file name
    int hashCode = fileName.hashCode();
    // Take the absolute value to handle negative hash codes
    hashCode = Math.abs(hashCode);
    // Take the last 5 digits of the hash code
    String identifier = String.format("%05d", hashCode % 100000);
    return identifier;
}
}