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

        // Regex to match HTML tags (opening, closing, or self-closing)
        Pattern tagPattern = Pattern.compile("</?[a-zA-Z0-9]+(/)?>");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = tagPattern.matcher(line);
                while (matcher.find()) {
                    String tag = matcher.group(); // Extract the tag

                    // Skip self-closing tags
                    if (tag.endsWith("/>") || tag.equals("<br>") || tag.equals("<img>")) {
                        continue;
                    }

                    if (tag.startsWith("</")) {
                        // Closing tag
                        String closingTag = tag.substring(2, tag.length() - 1); // Remove </ and >
                        StringStackImpl tempStack = new StringStackImpl();
                        boolean matched = false;

                        // Look for a matching opening tag in the stack
                        while (!tagStack.isEmpty()) {
                            String topTag = tagStack.pop(); // Pop the top of the stack
                            if (topTag.equals(closingTag)) {
                                // Match found, stop searching
                                matched = true;
                                break;
                            } else {
                                // Temporarily store unmatched tags
                                tempStack.push(topTag);
                            }
                        }

                        // Restore the stack if no match was found
                        if (!matched) {
                            System.out.println("Unexpected closing tag: </" + closingTag + ">");
                            hasErrors = true;
                        }

                        // Restore the stack from tempStack
                        while (!tempStack.isEmpty()) {
                            tagStack.push(tempStack.pop());
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
