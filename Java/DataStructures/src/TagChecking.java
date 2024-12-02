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

        // Create stack to hold the html tags. 
        StringStackImpl tagStorage = new StringStackImpl();
        boolean tagErrorsFound = false;

        //* Identify HTML tags
        Pattern htmlTagPattern = Pattern.compile("</?[a-zA-Z0-9]+(/)?>"); // /? = will count it with or woithout the slash. [a-z],[A-Z],[0-9]

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // match tags with the lines
                Matcher matcher = htmlTagPattern.matcher(line);
                while (matcher.find()) {
                    String tag = matcher.group(); // Extract the tag

                    // Ignore tags like <br> and <img>
                    if (tag.equals("<br>") || tag.equals("<img>")) {
                        continue;
                    }

                    if (tag.startsWith("</")) {

                        //* Handle closing HTML tag

                        String closingTag = tag.substring(2, tag.length() - 1); // Remove </ and >

                        //* Create a temporary stack to check for unexpected closing tags
                        StringStackImpl temporaryTagHolder = new StringStackImpl(); 
                        // Unable to fix it without using a temporary stack hope it doesn't mess with time complexity 
                        boolean matched = false;

                        //* Look for a matching opening tag in the stack
                        while (!tagStorage.isEmpty()) {
                            String topTag = tagStorage.pop(); // Pop the top of the stack
                            if (topTag.equals(closingTag)) {
                                //* Match found, stop searching
                                matched = true;
                                break;
                            } else {
                                //* Use a temporary stack for unmatched tags
                                temporaryTagHolder.push(topTag);
                            }
                        }

                        //! If no matching opening tag was found, print an error 
                        if (!matched) {
                            System.out.println("Unexpected closing tag: </" + closingTag + ">");
                            tagErrorsFound = true;
                        }

                        //* Restore unmatched tags back to the main stack
                        while (!temporaryTagHolder.isEmpty()) {
                            tagStorage.push(temporaryTagHolder.pop());
                        }
                    } else {
                        //* Handle opening tag (remove < and >  )
                        String openingTag = tag.substring(1, tag.length() - 1);
                        tagStorage.push(openingTag);
                    }
                }
            }

            //* Check for any remaining unmatched opening tags
            while (!tagStorage.isEmpty()) {

                //! Print Unmatched opening tag(/s)
                System.out.println("Unmatched  opening tag: <" + tagStorage.pop() + ">");
                tagErrorsFound = true;
            }

            if (!tagErrorsFound) {
                System.out.println("All tags are properly closed.");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
