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

public class func {
    public static void main(String[] args) {
        Login login = new Login();
        Register register = new Register();

    }
}

class Login{
    public static List<String> login(){
        Scanner scanner = new Scanner(System.in);
        List<String> credentials = new ArrayList<>();
        String username,password;

        System.out.println("===> LOGIN <===");
        System.out.print("Username (lowercase): ");
        String userName = scanner.nextLine();
        
        System.out.print("Password: ");
        String userPassword = scanner.nextLine();
        
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