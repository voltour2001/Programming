import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //! Initialize premade questions
        List<MultipleChoice> MultipleChoiceQuestions = new ArrayList<>();
        MultipleChoiceQuestions.addAll(premadeMultipleChoiceQuestions());
        List<SingleWord> SingleWordQuestions = new ArrayList<>();
        SingleWordQuestions.addAll(premadeSingleWordQuestions());

        //* Create Custom Multiple Choice question from user input
        // List<MultipleChoice> customMultipleChoiceQuestion = MultipleChoice.createFromUserInput();
        // MultipleChoice.addAll(customMultipleChoiceQuestion);
        //* Create Custom Single word question from user input
        // List<SingleWord> customSingleWordQuestion = SingleWord.createFromUserInput();
        // SingleWord.addAll(customSingleWordQuestion);
        
        //! Display premade questions
        for (int i = 0; i < SingleWordQuestions.size(); i++) {
            SingleWord question = SingleWordQuestions.get(i);
            System.out.println("\n");
            question.displaySingleWord();
        }

        //! Example of user answers
        List<String> userResponseMultiple = new ArrayList<>();
        List<String> userResponseSingle = new ArrayList<>();
        userResponseMultiple.add("1");
        userResponseMultiple.add("2");
        userResponseSingle.add("final");

        boolean isCorrect;
        
        System.out.println("\n");
        //* IsCorrect for MultipleChoiceQuestion */
        isCorrect = MultipleChoiceQuestions.get(0).isCorrect(userResponseMultiple);
        System.out.println("Multiple question 1:" + isCorrect); 
        //* IsCorrect for SingleWordQuestion */
        isCorrect = SingleWordQuestions.get(0).isCorrect(userResponseSingle);
        System.out.println("Single question 1:" + isCorrect); 

        scanner.close();
    }






    //! Create a premade question template
    //* Example for a premade Multiple Choice Questions
    private static List<MultipleChoice> premadeMultipleChoiceQuestions() {
        List<MultipleChoice> questions = new ArrayList<>();

        String code1 = "101";
        String description1 = "This is a manually created question 1";
        List<String> answerOptions1 = List.of("Option A", "Option B", "Option C", "Option D");
        List<Integer> correctChoices1 = List.of(1, 2); // Assuming correct answers are Option A and Option B
        questions.add(new MultipleChoice(code1, description1, answerOptions1, correctChoices1));

        String code2 = "102";
        String description2 = "This is a manually created question 2";
        List<String> answerOptions2 = List.of("Option E", "Option F", "Option G", "Option H");
        List<Integer> correctChoices2 = List.of(3); // Assuming correct answer is Option G
        questions.add(new MultipleChoice(code2, description2, answerOptions2, correctChoices2));

        String code3 = "103";
        String description3 = "This is a manually created question 3";
        List<String> answerOptions3 = List.of("Option I", "Option J", "Option K", "Option L");
        List<Integer> correctChoices3 = List.of(2,4); // Assuming correct answer is Option L
        questions.add(new MultipleChoice(code3, description3, answerOptions3, correctChoices3));

        return questions;
    }

    private static List<SingleWord> premadeSingleWordQuestions() {
        List<SingleWord> questions = new ArrayList<>();

        String code1 = "201";
        String description1 = "Test 1";
        String correctAnswer1 = "final";
        questions.add(new SingleWord(code1, description1, correctAnswer1));

        String code2 = "202";
        String description2 = "Test 2";
        String correctAnswer2 = "54";
        questions.add(new SingleWord(code2, description2, correctAnswer2));

        String code3 = "203";
        String description3 = "Test 3";
        String correctAnswer3 = "int";
        questions.add(new SingleWord(code3, description3, correctAnswer3));

        return questions;
    }
}
