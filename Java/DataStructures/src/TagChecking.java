package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagChecking {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to an HTML file.");
            return;
        }

        String filePath = args[0];
        StringStackImpl tagStack = new StringStackImpl();
        boolean hasErrors = false;

        // Regex to match HTML tags (opening or closing)
        Pattern tagPattern = Pattern.compile("</?[a-zA-Z0-9]+>");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = tagPattern.matcher(line);
                while (matcher.find()) {
                    String tag = matcher.group(); // Extract the tag
                    if (tag.startsWith("</")) {
                        // Closing tag
                        String closingTag = tag.substring(2, tag.length() - 1); // Remove </ and >
                        while (true) {
                            if (tagStack.isEmpty()) {
                                System.out.println("Unmatched closing tag: " + tag);
                                hasErrors = true;
                                break;
                            }

                            String topTag = tagStack.pop(); // Check the top of the stack
                            if (topTag.equals(closingTag)) {
                                // Match found, stop checking
                                break;
                            } else {
                                System.out.println("Tag mismatch: expected </" + topTag + ">, found " + tag);
                                hasErrors = true;
                                // Keep checking the same closing tag with the next item in the stack
                            }
                        }
                    } else {
                        // Opening tag (remove < and >)
                        String openingTag = tag.substring(1, tag.length() - 1);
                        tagStack.push(openingTag);
                    }
                }
            }

            // Check for unmatched opening tags
            while (!tagStack.isEmpty()) {
                System.out.println("Unmatched opening tag: <" + tagStack.pop() + ">");
                hasErrors = true;
            }

            if (!hasErrors) {
                System.out.println("All tags are properly closed.");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
