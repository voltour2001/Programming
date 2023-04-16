import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hello{
    public static void main(String[] args) throws IOException {
        
        // Need Try/throws because this might cause a system error
        File myObj = new File("C:\\Users\\1spir\\Documents\\Programming\\Java\\test.txt");
        Scanner scan = new Scanner(myObj);

        String text = "This is the nmew file created with JAVA!\n";
        while (scan.hasNextLine()) {
            text = text.concat(scan.nextLine() + "\n");       
        }
        FileWriter writer = new FileWriter("C:\\Users\\1spir\\Documents\\Programming\\Java\\newFile.txt");
        writer.write(text);
        writer.close();
    }
}