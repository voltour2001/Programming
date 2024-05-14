import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleWordQuestion extends Question {

    String correctAnswer;

    //! Constructor
    public SingleWordQuestion(String code, String description, String correctAnswer) {
        super(code, description);
        this.correctAnswer = correctAnswer;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public static List<SingleWordQuestion> createFromUserInput() {
        
        List<SingleWordQuestion> questions = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Code: ");
        String code = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Correct Answer: ");
        String correctAnswer = scanner.nextLine();

        SingleWordQuestion question = new SingleWordQuestion(code, description, correctAnswer);
        return List.of(question); // return a list of questions;
    }

    public void displaySingleWordQuestion() {

        System.out.println("Code: " + getCode());
        System.out.println("Description: " + getDescription());
        System.out.println("Correct Answer: " + correctAnswer);
    }
    @Override
    public boolean isCorrect(List<String> userResponse) {
        boolean x = false;
        if (userResponse.get(0).equals(correctAnswer)) {
            x = true;
        }
        return x;
        
    }
    
}