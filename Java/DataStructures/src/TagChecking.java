package src;

import java.io.*;

public class TagChecking {
    public static void main(String[] args) {
        // Check if filename is provided
        if (args.length != 1) {
            System.out.println("Usage: java TagChecking <path_to_html_file>");
            return;
        }

        String filePath = args[0];
        StringStackImpl tagStack = new StringStackImpl();  // Using your existing StringStackImpl
        StringStackImpl errors = new StringStackImpl();  // Stack to collect all error messages

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int startIdx = line.indexOf('<');
                while (startIdx != -1) {
                    int endIdx = line.indexOf('>', startIdx);
                    if (endIdx != -1) {
                        // Extract the tag
                        String tag = line.substring(startIdx + 1, endIdx).trim();

                        // Push the tag into the stack if it's a valid tag
                        if (!tag.isEmpty()) {
                            tagStack.push(tag);
                        }

                        // Search for next tag in the line
                        startIdx = line.indexOf('<', endIdx);
                    } else {
                        // No closing '>' found, break
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Now, let's validate the tags using a new validation stack
        StringStackImpl validationStack = new StringStackImpl();

        // Process the tags in order and validate proper nesting
        while (!tagStack.isEmpty()) {
            String tag = tagStack.pop();

            // Ignore self-closing tags like <br> and <img>
            if (tag.equals("br") || tag.equals("img")) {
                continue;
            }

            // If it's a closing tag
            if (tag.startsWith("/")) {
                // Get the name of the tag without the '/'
                String tagName = tag.substring(1); 
                // Push the tag name to validationStack to match later
                validationStack.push(tagName);
            } else {
                // It's an opening tag
                if (validationStack.isEmpty()) {
                    errors.push("Error: No matching closing tag for <" + tag + ">");
                } else {
                    // Pop the expected closing tag from validationStack
                    String expectedTag = validationStack.pop();
                    if (!expectedTag.equals(tag)) {
                        errors.push("Mismatched tags: expected </" + tag + ">, but found </" + expectedTag + ">");
                    }
                }
            }
        }

        // At the end, if validationStack is not empty, some tags were never closed
        while (!validationStack.isEmpty()) {
            String unclosedTag = validationStack.pop();
            errors.push("Error: No matching opening tag for </" + unclosedTag + ">");
        }

        // Final Pass: Ensure All Tags Have Matching Counterparts, Regardless of Order
        finalValidation(tagStack, errors);

        // Print all errors collected during the process
        if (errors.isEmpty()) {
            System.out.println("All tags are properly matched!");
        } else {
            System.out.println("Errors found during HTML validation:");
            while (!errors.isEmpty()) {
                System.out.println(errors.pop());
            }
        }
    }

    // Final Validation: Ensure that every tag has a counterpart, without considering nesting
    private static void finalValidation(StringStackImpl originalTagStack, StringStackImpl errors) {
        // Create separate stacks for unmatched opening and closing tags
        StringStackImpl unmatchedOpeningStack = new StringStackImpl();
        StringStackImpl unmatchedClosingStack = new StringStackImpl();

        // Copy tags to new stacks for the final validation
        while (!originalTagStack.isEmpty()) {
            String tag = originalTagStack.pop();
            if (tag.startsWith("/")) {
                unmatchedClosingStack.push(tag.substring(1)); // Add closing tag (without '/')
            } else {
                unmatchedOpeningStack.push(tag); // Add opening tag
            }
        }

        // Perform matching without considering order
        StringStackImpl tempStack = new StringStackImpl(); // Temporary stack for unmatched tags

        while (!unmatchedOpeningStack.isEmpty()) {
            String openTag = unmatchedOpeningStack.pop();
            boolean matchFound = false;

            while (!unmatchedClosingStack.isEmpty()) {
                String closeTag = unmatchedClosingStack.pop();
                if (openTag.equals(closeTag)) {
                    // Match found, break and discard
                    matchFound = true;
                    break;
                } else {
                    // Push unmatched closing tag to temp stack
                    tempStack.push(closeTag);
                }
            }

            // Push unmatched tags back to unmatchedClosingStack
            while (!tempStack.isEmpty()) {
                unmatchedClosingStack.push(tempStack.pop());
            }

            if (!matchFound) {
                // No match found for the opening tag
                errors.push("Error: No matching closing tag for <" + openTag + ">");
            }
        }

        // Any remaining tags in unmatchedClosingStack are unmatched closing tags
        while (!unmatchedClosingStack.isEmpty()) {
            String unmatchedClosingTag = unmatchedClosingStack.pop();
            errors.push("Error: No matching opening tag for </" + unmatchedClosingTag + ">");
        }

        errors.push("Final matching check complete.");
    }
}
