package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TagChecking {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TagChecking <filename>");
            return;
        }

        String fileName = args[0];
        StringStackImpl stack = new StringStackImpl();
        boolean hasErrors = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                hasErrors |= processLine(line, stack); // Process each line
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (!stack.isEmpty()) {
            hasErrors = true;
            System.out.println("Error: Unmatched opening tags remaining in the stack:");
            while (!stack.isEmpty()) {
                System.out.println("<" + stack.pop() + "> left open.");
            }
        }

        if (!hasErrors) {
            System.out.println("All tags are properly nested.");
        }
    }

    private static boolean processLine(String line, StringStackImpl stack) {
        int i = 0;
        boolean foundError = false;

        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                int j = i + 1;

                // Find the end of the tag
                while (j < line.length() && line.charAt(j) != '>') {
                    j++;
                }

                if (j >= line.length()) {
                    return true; // Invalid tag
                }

                String tag = line.substring(i + 1, j).trim();
                if (tag.startsWith("/")) {
                    String closingTag = tag.substring(1);
                    if (!stack.isEmpty() && stack.peek().equals(closingTag)) {
                        stack.pop(); // Matching opening tag found
                    } else {
                        foundError = true;
                        if (!stack.isEmpty()) {
                            System.out.println("Error: Tag mismatch! Expected </" + stack.peek() + "> but found </" + closingTag + ">.");
                            stack.pop();
                        } else {
                            System.out.println("Error: Unmatched closing tag </" + closingTag + ">.");
                        }
                    }
                } else if (!isSelfClosing(tag)) {
                    stack.push(tag); // Push opening tag onto the stack
                }

                i = j; // Move past the closing '>'
            }
            i++;
        }

        return foundError;
    }

    private static boolean isSelfClosing(String tag) {
        return tag.equals("br") || tag.equals("img") || tag.equals("meta") || tag.equals("hr");
    }
}
