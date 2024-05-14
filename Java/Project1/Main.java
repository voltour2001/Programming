import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //* Create list to hold MuiltipleChoice questions
        List<MultipleChoiceQuestion> questions = new ArrayList<>();
        questions.add(premadeQuestion());


        //* Custom Question from user input
        List<MultipleChoiceQuestion> customQuestion = MultipleChoiceQuestion.createFromUserInput();
        questions.add(customQuestion.get(0)); // if multiple questions we need loop

        
        //! Display all questions
        for (MultipleChoiceQuestion question : questions) {
            question.displayMultipleChoiceQuestion();
        }


        //* Example of user answers
        List<String> userResponse = new ArrayList<>();
        userResponse.add("1");
        userResponse.add("2");

        boolean isCorrect;
        
        isCorrect = questions.get(0).isCorrect(userResponse);
        System.out.println("Question 1:" + isCorrect); 

        isCorrect = questions.get(1).isCorrect(userResponse);
        System.out.println("Question 2:" + isCorrect); 



        scanner.close();
    }


    //! Create a premade question template
    //* Example for a premade Multiple Choice Question
    private static MultipleChoiceQuestion premadeQuestion() {
        String code = "Q1";
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
