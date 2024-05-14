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

    //! Display question (code, description, answer options, correct answer(s))
    //? How to call, inside a loop: 
    //? => question.displayMultipleChoiceQuestion();
    public void displayMultipleChoiceQuestion() {

        //* UI 
        System.out.print("Code: " + getCode() + " |");
        System.out.println("Question: " + getDescription());
        System.out.println("Answer Options:");

        //* Displays the answer options
        for (int i = 0; i < answerOptions.size(); i++) {

            System.out.print((i + 1) + ". ");
            
            for (String option : answerOptions.get(i)) {
                System.out.print(option + " ");
            }
            
            System.out.println();
        }
        
        //* Displays the correct choice(s)
        System.out.println("Correct Answer(s):");
        for (List<Integer> correctChoice : correctChoices) {
            System.out.println(correctChoice);
        }
    }

    //! Create new multiple choice questions from user input
    //* Asks for Each question : Code, Description, [4 answer options], [correct answer(s)]
    //* Returns a list that each index = list of question
    //* Each sublist index = [code, description, [4 answer options], [correct answer(s)] ]
    //  Example = [ [ Q1 ], [ Q2 ] ]    (Q1 = [code, description, 4 answer options, correct answer(s)])
    //? How to call => List<MultipleChoiceQuestion> questions = MultipleChoiceQuestion.createFromUserInput();
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

    
    //? How to call =>     
    /*  //*  Example of how to use it
    List<String> userResponse = new ArrayList<>();    
    userResponse.add("1");
    userResponse.add("2");
    boolean isCorrect = questions.get(0).isCorrect(userResponse);
    */
    @Override
    public boolean isCorrect(List<String> userResponse) {
        List<Integer> userChoices = new ArrayList<>();

        //* Convert userResponse to List<Integer>
        for (String response : userResponse) {
            userChoices.add(Integer.parseInt(response));
        }
        return correctChoices.contains(userChoices);
    }
    


}
