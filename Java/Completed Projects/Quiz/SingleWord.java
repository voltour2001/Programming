import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleWord extends Question {

    private String correctAnswer;

    // Constructor
    public SingleWord(String code, String description, String correctAnswer) {
        super(code, description);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Returns a list of questions from user input
    public static List<SingleWord> createFromUserInput() {
        List<SingleWord> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Correct Answer: ");
        String correctAnswer = scanner.nextLine();

        SingleWord question = new SingleWord(code, description, correctAnswer);
        questions.add(question);

        return questions; // return a list of questions
    }

    // Display question (code, description)
    @Override
    public void display() {
        System.out.println();
        System.out.println("Code: " + getCode());
        System.out.println("Description: " + getDescription());
    }

    // Check if the user response is correct (case insensitive)
    @Override
    public boolean isCorrect(List<String> userResponse) {
        if (userResponse.isEmpty()) {
            return false;
        }
        String userAnswer = userResponse.get(0);
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    public static void main(String[] args) {
        // Example usage
        List<SingleWord> questions = SingleWord.createFromUserInput();
        for (SingleWord question : questions) {
            question.display();
            List<String> userResponse = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer: ");
            userResponse.add(scanner.nextLine());
            System.out.println("Your answer is " + (question.isCorrect(userResponse) ? "correct" : "incorrect"));
        }
    }
}