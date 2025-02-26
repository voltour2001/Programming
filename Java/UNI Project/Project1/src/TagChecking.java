package src;

import java.io.*;
import java.util.Scanner;

public class TagChecking {
    public static void main(String[] args) throws IOException {
        String filePath;
        if (args.length != 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the path to the HTML file:");
            filePath = scanner.nextLine();
            scanner.close();
        } else {
            filePath = args[0];
        }
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringStackImpl stack = new StringStackImpl();
        while ((line = reader.readLine()) != null) {

            line = line.trim();
            if (line.startsWith("<!DOCTYPE")) {
                continue;
            }

            while (line.contains("<") && line.contains(">")) {
                int start = line.indexOf("<");
                int end = line.indexOf(">");

                String tag = line.substring(start + 1, end);
                boolean ClosingTag = tag.startsWith("/");

                if (ClosingTag) {
                    String tagName = tag.substring(1); // Remove the '/'
                    if (stack.isEmpty() || !stack.peek().equals(tagName)) {
                        System.out.println("Mismatch: Expected </" + stack.peek() + "> but found </" + tagName + ">");
                        return;
                    } else {
                        stack.pop();
                    }
                } else {

                    if (!tag.equals("br") && !tag.equals("img")) {
                        stack.push(tag);
                    }
                }
                line = line.substring(end + 1).trim();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("All tags are correctly matched.");
        } else {
            System.out.println("Mismatch: There are unclosed tags.");
        }

        reader.close();

    }
}
