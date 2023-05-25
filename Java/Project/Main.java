package Project;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        int choice;
        int id = 100;
        Scanner scanner = new Scanner(System.in);
        List<List<Object>> myList = new ArrayList<>();


        //* Get AFM from user
        System.out.print("\nInsert AFM: ");
        int AFM = scanner.nextInt();
        user.userCheck(AFM);
        System.out.println("____________________\n");

        while (true){
    
            System.out.println("Menu:");
            System.out.println("1. New Ad");
            System.out.println("2. Print All Ads");
            System.out.println("3. Print AFM Ads");
            System.out.println("4. Print Ad Cost (need ID)");
            System.out.println("5. Print All Ads Cost (based on AFM)");

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) { // hasNextInt() examines the next token in the input stream without consuming it. Returns true if integer.
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            
                //* If Choice is to create new add *//
                if (choice == 1){
                    
                    List<Object> objectList = newAdvert.newAd(id, AFM);
                    myList.add(objectList);

                    //* Write the add to a file *//
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("./files/adds.txt", true))) {
                        for (List<Object> sublist : myList) {
                            boolean firstElement = true;

                            for (Object obj : sublist) {

                                if (firstElement) {
                                    writer.write(obj.toString());
                                    firstElement = false;

                                } else {
                                    writer.write(" ");
                                    writer.write(obj.toString());
                                }
                            }
                            writer.newLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if (choice == 2){

                }

            }
        }
        
    }
}