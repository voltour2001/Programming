package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TagChecking {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to an HTML file.");
            return;
        }

        StringStackImpl stack = new StringStackImpl();
        String filePath = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int index = 0;
                while (index < line.length()) {
                    // Find the start of a tag
                    int tagStart = line.indexOf('<', index);
                    if (tagStart == -1) {
                        break;
                    }
                    int tagEnd = line.indexOf('>', tagStart);
                    if (tagEnd == -1) {
                        break; // Invalid tag, ignore
                    }

                    String tag = line.substring(tagStart + 1, tagEnd).trim();
                    index = tagEnd + 1;

                    if (!tag.equals("br") && !tag.equals("img")) {
                        // Add all tags (both opening and closing) to the stack
                        stack.push(tag);
                    }
                }
            }

            // Create a second stack that is the original stack reversed
            StringStackImpl reversedStack = new StringStackImpl();
            StringStackImpl tempStack = new StringStackImpl();

            // Transfer elements from the original stack to a temporary stack and reversed stack
            while (!stack.isEmpty()) {
                String tag = stack.pop();
                tempStack.push(tag);
                reversedStack.push(tag);
            }

            // Restore the original stack from the temporary stack
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

            // Print both stacks for verification
            System.out.print("Original Stack:\n[");
            tempStack = new StringStackImpl();
            while (!stack.isEmpty()) {
                String tag = stack.pop();
                System.out.print("[" + tag + "]" + (stack.isEmpty() ? "" : ", "));
                tempStack.push(tag);
            }
            System.out.println("]");

            System.out.print("Reversed Stack:\n[");
            tempStack = new StringStackImpl();
            while (!reversedStack.isEmpty()) {
                String tag = reversedStack.pop();
                System.out.print("[" + tag + "]" + (reversedStack.isEmpty() ? "" : ", "));
                tempStack.push(tag);
            }
            System.out.println("]");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        


    }
}
