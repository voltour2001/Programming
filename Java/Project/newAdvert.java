package Project;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class newAdvert{
    
    public static List<Object> newAd(int id, int AFM){
        
        String discreption;
        
        int choice;

        int price1, price2, price3, price4;

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
                    System.out.print("Price per word in the 1st page: ");
                    price1 = scanner.nextInt();
                    System.out.print("Price per word in the 2nd page: ");
                    price2 = scanner.nextInt();
                    System.out.print("Price per word in the 3rd page: ");
                    price3 = scanner.nextInt();
                    System.out.println("\n");
                    
                    // Add Items to myList
                    myList.add(id);
                    myList.add(AFM);
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
                    System.out.print("Price per day: ");
                    price1 = scanner.nextInt();
                    System.out.print("Price per time add is automated shown: ");
                    price2 = scanner.nextInt();
                    System.out.print("Price per extra page: ");
                    price3 = scanner.nextInt();
                    
                    // Add Items to myList
                    myList.add(id);
                    myList.add(AFM);
                    myList.add(discreption);
                    myList.add(price1);
                    myList.add(price2);
                    myList.add(price3);

                    return myList;

                }
                //* Radio Add
                else if (choice == 3){

                    // Discreption 
                    System.out.println("____________________\n");
                    System.out.println("You picked Website Add");        
                    System.out.println("____________________\n");
                    System.out.print("Enter Description for the add:");
                    discreption = scanner.nextLine();

                    // Prices
                    System.out.print("Price per Second Mornings: ");
                    price1 = scanner.nextInt();
                    System.out.print("Price per Second Noon: ");
                    price2 = scanner.nextInt();
                    System.out.print("Price per Second Afternoon: ");
                    price3 = scanner.nextInt();
                    System.out.print("Price per Second Night: ");
                    price4 = scanner.nextInt();
                    
                    // Add Items to myList
                    myList.add(id);
                    myList.add(AFM);
                    myList.add(discreption);
                    myList.add(price1);
                    myList.add(price2);
                    myList.add(price3);
                    myList.add(price4);

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
}
