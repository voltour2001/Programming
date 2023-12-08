import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hello{
    public static void main(String[] args) throws IOException {
        
        // Need Try/throws because this might cause a system error
        File myObj = new File("test.txt");
        Scanner scan = new Scanner(myObj);

        String text = "This is the new file created with JAVA!\n";
        while (scan.hasNextLine()) {
            text = text.concat(scan.nextLine() + "\n");       
        }
        FileWriter writer = new FileWriter("newFile.txt");
        writer.write(text);
        writer.close();

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> squaredNumbers = squareList(numbers);
        System.out.println(numbers); // Output: [1, 2, 3, 4, 5]
        System.out.println(squaredNumbers); // Output: [1, 4, 9, 16, 25]
        
    }


    public static List<Integer> squareList(List<Integer> inputList) {
        List<Integer> squaredList = new ArrayList<>();
        for (Integer number : inputList) {
            squaredList.add(number * number);
        }
        return squaredList;
    }
}
