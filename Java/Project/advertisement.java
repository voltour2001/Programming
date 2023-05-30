package Project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class advertisement{
    
    public static List<Object> newAd(int id, int AFM){
        
        String discreption;
        
        int choice;
        int words;
        int price1, price2, price3, price4, price5;

        Scanner scanner = new Scanner(System.in);
        
        List<Object> myList = new ArrayList<>();
        

        //* New Add 
        System.out.print("""

        What type of add do you want.
        Input 1 for printed add
        Input 2 for website add
        Input 3 for radio add
        Enter your choice: """);

        if (scanner.hasNextInt()) { // hasNextInt() examines the next token in the input stream without consuming it. Returns true if integer.
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1 || choice == 2 || choice == 3) {

                //* Printed Add
                if (choice == 1){    

                    // Discreption 
                    System.out.println("____________________\n");
                    System.out.println("You picked printed add");
                    System.out.println("____________________\n");

                    System.out.print("Enter Description for the add: ");
                    discreption = scanner.nextLine();
                    
                    // Prices
                    
                    System.out.print("How many words: ");
                    price1 = scanner.nextInt();
                    System.out.print("Price per word: ");
                    price2 = scanner.nextInt();
                    System.out.print("Ad duration(seconds): ");
                    price3 = scanner.nextInt();
                    System.out.println("\n");
                    
                    // Add Items to myList
                    
                    myList.add(id);
                    myList.add(AFM);
                    myList.add(1);
                    myList.add(discreption);
                    myList.add(price1);
                    myList.add(price2);
                    myList.add(price3);

                    return myList;
                                
                }
                //* Website Add
                else if (choice == 2){

                    // Discreption 
                    System.out.println("____________________\n");
                    System.out.println("You picked Website Add");
                    System.out.println("____________________\n");
                    System.out.print("Enter Description for the add:");
                    discreption = scanner.nextLine();
                    
                    // Prices
                    // «χρονική διάρκεια εμφάνισης» + «κόστος αυτόματης εμφάνισης (εάν έχει ενεργοποιηθεί)» + «επιπλέον σελίδες»
                    System.out.print("Price per day: ");
                    price1 = scanner.nextInt();
                    System.out.print("Duration of appearance: ");
                    price2 = scanner.nextInt();
                    System.out.print("Automated show cost: ");
                    price3 = scanner.nextInt();
                    System.out.print("Extra pages: ");
                    price4 = scanner.nextInt();
                    System.out.print("Price per Extra page: ");
                    price5 = scanner.nextInt();

                    
                    // Add Items to myList
                    myList.add(id);
                    myList.add(AFM);
                    myList.add(2);
                    myList.add(discreption);
                    myList.add(price1);
                    myList.add(price2);
                    myList.add(price3);
                    myList.add(price4);
                    myList.add(price5);

                    return myList;

                }
                //* Radio Add
                else if (choice == 3){

                    // Discreption 
                    System.out.println("____________________\n");
                    System.out.println("You picked Radio Add");        
                    System.out.println("____________________\n");
                    System.out.print("Enter Description for the add:");
                    discreption = scanner.nextLine();

                    // Prices
                    System.out.print("Ad duration: ");
                    price1 = scanner.nextInt();
                    System.out.print("Price per second: ");
                    price2 = scanner.nextInt();
                    System.out.print("Duration of appearance: ");
                    price3 = scanner.nextInt();
                    
                    // Add Items to myList
                    myList.add(id);
                    myList.add(AFM);
                    myList.add(3);
                    myList.add(discreption);
                    myList.add(price1);
                    myList.add(price2);
                    myList.add(price3);

                    return myList;

                }

            }else {
                    String invalidInput = scanner.next();
                    System.out.println("Invalid input: " + invalidInput);
                    System.out.println("Please enter a valid integer choice.");
                    scanner.nextLine(); // Consume the newline 
            }
 
        }
        return new ArrayList<>();
    }
    
    public static void cost(int ID) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("./files/adds.txt"))) {
            
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null && found == false) {
                String[] elements = line.split(",");
                
                if (Integer.parseInt(elements[0]) == ID) {
                    //* Cost if ad is printed
                    if(Integer.parseInt(elements[2]) == 1){
                        
                        int words = Integer.parseInt(elements[4]);
                        int pricePerWord = Integer.parseInt(elements[5]);
                        int duration = Integer.parseInt(elements[6]);
                        int cost =  words * pricePerWord * duration; 
                        System.out.println("Cost of add = " + cost);
                        found = true;
                    }
                    //* Cost if ad is Website
                    else if (Integer.parseInt(elements[2]) == 2){

                        int pricePerDay = Integer.parseInt(elements[4]);
                        int durationAppearance = Integer.parseInt(elements[5]);
                        int automatedShowCost = Integer.parseInt(elements[6]);
                        int extraPages = Integer.parseInt(elements[7]);
                        int costOfExtraPages = Integer.parseInt(elements[8]);
                        int cost = pricePerDay * (durationAppearance + automatedShowCost + extraPages) * costOfExtraPages;
                        System.out.println("Cost of add = " + cost);
                        found = true;

                    }   
                    //* Cost if ad is Radio 
                    else if (Integer.parseInt(elements[2]) == 3) {

                        int duration = Integer.parseInt(elements[4]);
                        int pricePerSecond = Integer.parseInt(elements[5]);
                        int durationAppearance = Integer.parseInt(elements[6]);
                        int cost = duration * pricePerSecond * durationAppearance;
                        System.out.println("Cost of add = " + cost);
                        found = true;

                    }
                    
                }
            }
            if (found == false){
                System.out.println("Unable to locate Advertisement.");
                found = true;
            }
                
                System.out.println(); // Move to the next line
        }catch (IOException e) {
                e.printStackTrace();
        }        
    }
    
    public static void allCost(int AFM) {
        try (BufferedReader br = new BufferedReader(new FileReader("./files/adds.txt"))) {
            
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split(",");
                if (Integer.parseInt(elements[1]) == AFM){
                    //* Cost if ad is printed
                    if(Integer.parseInt(elements[2]) == 1){
                        
                        int words = Integer.parseInt(elements[4]);
                        int pricePerWord = Integer.parseInt(elements[5]);
                        int duration = Integer.parseInt(elements[6]);
                        int cost =  words * pricePerWord * duration; 
                        System.out.println( "Ad ID: " + elements[0] + " - Cost = " + cost);
                    }                    
                    //* Cost if ad is Website
                    else if (Integer.parseInt(elements[2]) == 2){

                        int pricePerDay = Integer.parseInt(elements[4]);
                        int durationAppearance = Integer.parseInt(elements[5]);
                        int automatedShowCost = Integer.parseInt(elements[6]);
                        int extraPages = Integer.parseInt(elements[7]);
                        int costOfExtraPages = Integer.parseInt(elements[8]);
                        int cost = pricePerDay * (durationAppearance + automatedShowCost + extraPages) * costOfExtraPages;
                        System.out.println( "Ad ID: " + elements[0] + " - Cost = " + cost);

                    }   
                    //* Cost if ad is Radio 
                    else if (Integer.parseInt(elements[2]) == 3) {

                        int duration = Integer.parseInt(elements[4]);
                        int pricePerSecond = Integer.parseInt(elements[5]);
                        int durationAppearance = Integer.parseInt(elements[6]);
                        int cost = duration * pricePerSecond * durationAppearance;
                        System.out.println( "Ad ID: " + elements[0] + " - Cost = " + cost);

                    }
                }
        
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }  
}
