import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter correct choice(s) (separated by comma if multiple): ");

        String[] correctChoicesArray = scanner.nextLine().split(",");

        for (String string : correctChoicesArray) {
            
            System.out.println(string);
        }

    }
}
