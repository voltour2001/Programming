package Project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        int choice;
        int cost;
        int id = 100;
        try (BufferedReader br1 = new BufferedReader(new FileReader("./files/adds.txt"))) {
            String line1;
            while ((line1 = br1.readLine()) != null) {
                id++;
            }
            br1.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int AFM;
        Scanner scanner = new Scanner(System.in);
        List<List<Object>> myList = new ArrayList<>();


        //* Get AFM from user
        System.out.print("\nInsert AFM: ");
        AFM = scanner.nextInt();
        user.userCheck(AFM);

        while (true){
            System.out.println("""
            ____________________
            Menu:
            1. New User
            2. New Ad
            3. Print All Ads
            4. Print AFM Ads
            5. Print Ad Cost (need ID)
            6. Print All Ads Cost (based on AFM)""");

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) { // hasNextInt() examines the next token in the input stream without consuming it. Returns true if integer.
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                //* Change User *//
                if (choice == 1){
                    System.out.print("Enter AFM: ");
                    AFM = scanner.nextInt();
                    user.userCheck(AFM);
                }
                //* If Choice is to create new add *//
                else if (choice == 2){
                    
                    List<Object> objectList = advertisement.newAd(id, AFM);
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
                                    writer.write(",");
                                    writer.write(obj.toString());
                                }
                            }
                            writer.newLine();
                        
                        }
                        myList.clear();
                    
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    id++;

                }
                //* Print All Ads*//
                else if (choice == 3){
                    System.out.println("""
                        
                        --------------------
                        Printing All Adds
                        --------------------""");
                        try (BufferedReader br = new BufferedReader(new FileReader("./files/adds.txt"))) {
                            
                            String line;
                            
                            while ((line = br.readLine()) != null) {
                                String[] elements = line.split(",");
                                
                                for (int i = 0; i < elements.length; i++) {
                                    if (i != 1 ) {
                                        System.out.print(elements[i].trim());
                                        System.out.print(" ");
                                    } 
                                    
                                }
                                
                                System.out.println(); // Move to the next line
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                //* Print All Ads*//
                else if (choice == 4){
                    System.out.println("""
                        
                        --------------------------
                        Printing AFM Matching Adds
                        --------------------------""");
                    List<List<Object>> afmAds = user.searchAFM(AFM);
                    for (List<Object> list : afmAds) {
                        for (Object ad : list) {
                            System.out.print(ad + " ");
                        }
                        System.out.print("\n");
                    }
                }
                //* Print add Cost with ID
                else if (choice == 5){
                    int adID;
                    System.out.print("Enter Ad ID: ");
                    adID = scanner.nextInt();
                    advertisement.cost(adID);

                }
                //* Print all ads cost with AFM
                else if (choice == 6){
                    advertisement.allCost(AFM);
                }
            }
        }
        
    }


}