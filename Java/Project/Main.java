package Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        int id = 100;
        Scanner scanner = new Scanner(System.in);

        //* Get AFM from user
        System.out.print("\nInsert AFM: ");
        int AFM = scanner.nextInt();
        user.userCheck(AFM);
        System.out.println("____________________\n");


        List<Object> myList = menuInterface.menu(id, AFM);
        

        
        String discreption = (String) myList.get(2);
        int price1 = (int) myList.get(3);
        int price2 = (int) myList.get(4);
        int price3 = (int) myList.get(5);


        edipes add = new edipes(id, AFM, discreption, price1, price2, price3);

   

        System.out.println("=========================");
        add.print();



    }
}