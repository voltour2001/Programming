import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class test {

    //* ✅ Asks the user to enter userName & userPassword. Store it in list and return 
    public static List<String> credentials(){
        /*
         * Class to ask for userName & userPassword from user
         * Add that in a list and then return it with: 
         * Index 0 = userName 
         * Index 1 = userPassword
         */

        Scanner myObj = new Scanner(System.in);  // Create a Scanner to read user input

        System.out.print("Enter username: ");
        String userName = myObj.nextLine();  // Name Input
    
        System.out.print("Enter Password: ");
        String userPass = myObj.nextLine();  // Password input

        // Store in list and return list
        List<String> list = new ArrayList<>();
        list.add(userName);
        list.add(userPass);

        return list;
    }
    
    //* ✅ Insterts userName & userPassword to the data.txt file   
    public static void register(List<String> list) {
        /*
         *  Argument list = userName & userPassword
         *  Class to write the userName & userPassword to a file  
         */
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt", true));
            bw.write(list.get(0));
            bw.newLine();
            bw.write(list.get(1));
            bw.newLine();
            bw.close();

            System.out.println("===> Added Successfully <===");  // Output user input


        } catch (Exception ex) {
            return;    
        }

    }

    public static void main(String [] args) {

        System.out.println("\n===> Program Starts <===");  
        
        List<String> cred = credentials();
        
        register(cred);
        
    
    }

    public static void aaa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aaa'");
    }
}
