import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleChoice extends Question {
    
    private List<String> answerOptions;
    private List<Integer> correctChoices;

    // Constructor
    public MultipleChoice(String code, String description, List<String> answerOptions, List<Integer> correctChoices) {
        super(code, description);
        this.answerOptions = answerOptions;
        this.correctChoices = correctChoices;
    }

    //! Display question (code, description, answer options, correct answer(s))
    @Override
    public void display() {

        //* UI 
        System.out.println("\n");
        System.out.print("Code: " + getCode() + " | ");
        System.out.println("Question: " + getDescription());
        System.out.println("Answer Options:");

        //* Displays the answer options
        for (int i = 0; i < answerOptions.size(); i++) {
            System.out.println((i + 1) + ". " + answerOptions.get(i));
        }
        
    }

    //! Create new multiple choice questions from user input
    public static List<MultipleChoice> createFromUserInput() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create an empty list of questions
        List<MultipleChoice> questions = new ArrayList<>();

        // Prompt the user to enter details for the question
        System.out.println("Enter details for the question:");
        System.out.print("Enter code: ");
        String code = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        // Create an empty list to store answer options
        List<String> answerOptions = new ArrayList<>();

        // Loop to read answer options from the user
        for (int j = 1; j <= 4; j++) { // Modified to handle 4 answer options
            System.out.print("Enter answer option " + j + ": ");
            answerOptions.add(scanner.nextLine());
        }

        // Read the correct choices from the user
        System.out.print("Enter correct choice(s) (separated by comma if multiple): ");
        String[] correctChoicesArray = scanner.nextLine().split(",");

        // Create a list to store the correct choices
        List<Integer> correctChoices = new ArrayList<>();
        for (String choice : correctChoicesArray) {
            correctChoices.add(Integer.parseInt(choice.trim()));
        }

        // Create a new MultipleChoice object and add it to the list
        MultipleChoice question = new MultipleChoice(code, description, answerOptions, correctChoices);
        questions.add(question);

        // Close the scanner
        scanner.close();

        // Print space for readability
        System.out.println("\n");

        // Return the list of created questions
        return questions;
    }

    public List<Integer> getCorrectChoices() {
        return correctChoices;
    } 

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    @Override
    public boolean isCorrect(List<String> userResponse) {
        List<Integer> userChoices = new ArrayList<>();

        //* Convert userResponse to List<Integer>
        for (String response : userResponse) {
            userChoices.add(Integer.parseInt(response.trim()));
        }
        return correctChoices.containsAll(userChoices) && correctChoices.size() == userChoices.size();
    }
}
