import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleWord extends Question {

    String correctAnswer;

    //! Constructor
    public SingleWord(String code, String description, String correctAnswer) {
        super(code, description);
        this.correctAnswer = correctAnswer;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    //! Returns a list of a question from user input
    //? How to use:List<SingleWord> custom = SingleWord.createFromUserInput();
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
        return List.of(question); // return a list of questions;
    }



    //! Display question (code, description, correct answer)
    //? How to use:
    //? for (SingleWord question : SingleWords) {
    //?     System.out.println("\n");
    //?    question.displaySingleWord();
    //? }

    @Override
    public void display() {
        System.out.println("\n");
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