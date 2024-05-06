import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
    
    private List<List<String>> answerOptions;
    private List<List<Integer>> correctChoices;

    // Constructor
    public MultipleChoiceQuestion(String code, String description, List<List<String>> answerOptions, List<List<Integer>> correctChoices) {
        super(code, description);
        this.answerOptions = answerOptions;
        this.correctChoices = correctChoices;
    }

    // Method to display the question along with answer options and correct choice(s)
    public void displayQuestion() {
        // Displays the question code and description
        System.out.print("Code: " + getCode() + " |");
        System.out.println("Question: " + getDescription());
        
        // Displays the answer options
        System.out.println("Answer Options:");
        for (int i = 0; i < answerOptions.size(); i++) {
            System.out.print((i + 1) + ". ");
            for (String option : answerOptions.get(i)) {
                System.out.print(option + " ");
            }
            System.out.println();
        }
        
        // Displays the correct answer(s)
        System.out.println("Correct Answer(s):");
        for (List<Integer> correctChoice : correctChoices) {
            System.out.println(correctChoice);
        }
    }

    // Static method to create a list of MultipleChoiceQuestion objects based on user input
    public static List<MultipleChoiceQuestion> createFromUserInput() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create an empty list of questions
        List<MultipleChoiceQuestion> questions = new ArrayList<>();

        // Prompt the user for the number of questions
        System.out.print("\nEnter the number of questions: ");
        int numQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Generate multiple choice questions based on user input
        for (int i = 1; i <= numQuestions; i++) {

            // Prompt the user to enter details for each question
            System.out.println("Enter details for Question " + i + ":");
            System.out.print("Enter code: ");
            String code = scanner.nextLine();

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            // Create an empty list to store answer options
            List<List<String>> answerOptions = new ArrayList<>();

            // Loop to read answer options from the user
            for (int j = 1; j <= 4; j++) { // Modified to handle 4 answer options
                List<String> options = new ArrayList<>();
                System.out.print("Enter answer option " + j + ": ");
                options.add(scanner.nextLine());
                answerOptions.add(options);
            }

            // Read the correct choices from the user
            System.out.print("Enter correct choice(s) (separated by comma if multiple): ");
            String[] correctChoicesArray = scanner.nextLine().split(",");

            // Create a list to store the correct choices
            List<List<Integer>> correctChoices = new ArrayList<>();
            List<Integer> currentCorrectChoices = new ArrayList<>();
            for (String choice : correctChoicesArray) {
                if (choice.equals("-")) {
                    correctChoices.add(new ArrayList<>(currentCorrectChoices));
                    currentCorrectChoices.clear();
                } else {
                    currentCorrectChoices.add(Integer.parseInt(choice.trim()));
                }
            }
            if (!currentCorrectChoices.isEmpty()) {
                correctChoices.add(new ArrayList<>(currentCorrectChoices));
            }

            // Create a new MultipleChoiceQuestion object and add it to the list
            MultipleChoiceQuestion question = new MultipleChoiceQuestion(code, description, answerOptions, correctChoices);
            questions.add(question);
        }

        // Close the scanner
        scanner.close();

        // Print space for readability
        System.out.println("\n");

        // Return the list of created questions
        return questions;
    }

    public List<List<Integer>> getCorrectChoices() {
        return correctChoices;
    } 
}
