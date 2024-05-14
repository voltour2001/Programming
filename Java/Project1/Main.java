import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //* Create list to hold MuiltipleChoice questions
        List<MultipleChoiceQuestion> questions = new ArrayList<>();
        questions.add(premadeQuestion());

        //! Create Custom Single word question from user input
        //List<SingleWordQuestion> custom = SingleWordQuestion.createFromUserInput();

        //! Display Single word questions
        // for (SingleWordQuestion question : custom) {
        //     question.displaySingleWordQuestion();
        // }

        String code = "201";
        String description = "This is a test question";
        String correctAnswer = "Word";

        SingleWordQuestion question = new SingleWordQuestion(code, description, correctAnswer);
        List<SingleWordQuestion> custom = List.of(question);



        List<String> userResponse = new ArrayList<>();
        userResponse.add("Word");
        boolean isCorrect = question.isCorrect(userResponse);
        System.out.println("The Question is "+ isCorrect);

        // //* Custom Question from user input
        // List<MultipleChoiceQuestion> customQuestion = MultipleChoiceQuestion.createFromUserInput();
        // questions.add(customQuestion.get(0)); // if multiple questions we need loop

        
        // //! Display all questions
        // for (MultipleChoiceQuestion question : questions) {
        //     question.displayMultipleChoiceQuestion();
        // }


        // //* Example of user answers
        // List<String> userResponse = new ArrayList<>();
        // userResponse.add("1");
        // userResponse.add("2");

        // boolean isCorrect;
        
        // isCorrect = questions.get(0).isCorrect(userResponse);
        // System.out.println("Question 1:" + isCorrect); 

        scanner.close();
    }


    //! Create a premade question template
    //* Example for a premade Multiple Choice Question
    private static MultipleChoiceQuestion premadeQuestion() {
        String code = "101";
        String description = "This is a manually created question";
        List<List<String>> answerOptions = new ArrayList<>();
        answerOptions.add(List.of("Option A"));
        answerOptions.add(List.of("Option B"));
        answerOptions.add(List.of("Option C"));
        answerOptions.add(List.of("Option D"));
        List<List<Integer>> correctChoices = new ArrayList<>();
        correctChoices.add(List.of(1, 2)); // Assuming correct answers are Option A and Option B
        return new MultipleChoiceQuestion(code, description, answerOptions, correctChoices);
    }
}
