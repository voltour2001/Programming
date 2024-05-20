import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<EvaluatedParticipant> participants = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        //! Initialize premade questions
        List<MultipleChoice> MultipleChoiceQuestions = new ArrayList<>();
        MultipleChoiceQuestions.addAll(premadeMultipleChoiceQuestions());

        List<SingleWord> SingleWordQuestions = new ArrayList<>();
        SingleWordQuestions.addAll(premadeSingleWordQuestions());

        questions.addAll(MultipleChoiceQuestions);
        questions.addAll(SingleWordQuestions);

        //* New MultipleChoice from user input
        // List<MultipleChoice> customMultipleChoiceQuestion = MultipleChoice.createFromUserInput();
        // MultipleChoice.addAll(customMultipleChoiceQuestion);
        //* New SingleWord from user input
        // List<SingleWord> customSingleWordQuestion = SingleWord.createFromUserInput();
        // SingleWord.addAll(customSingleWordQuestion);
        
        for (Question question : questions) {
            question.display();
        }
        

        //! Example of user answers
        System.out.println("\n");
        
        List<String> userMulti = new ArrayList<>();
        List<String> userSingle = new ArrayList<>();

        userMulti.add("1");
        userMulti.add("2");
        userSingle.add("final");

        boolean isCorrect;
        
        
        //* IsCorrect for MultipleChoiceQuestion */
        isCorrect = MultipleChoiceQuestions.get(0).isCorrect(userMulti);
        System.out.println("Multiple question 1:" + isCorrect); 

        //* IsCorrect for SingleWordQuestion */
        isCorrect = SingleWordQuestions.get(0).isCorrect(userSingle);
        System.out.println("Single question 1:" + isCorrect); 

        scanner.close();
    }


    //! Create a premade question template
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
    
    // private static void showMenu() {
    //     Scanner scanner = new Scanner(System.in);
    //     while (true) {
    //         System.out.println("1. New Evaluator");
    //         System.out.println("2. Εισαγωγή νέας ερώτησης");
    //         System.out.println("3. Εισαγωγή νέας απάντησης");
    //         System.out.println("4. Εμφάνιση των ερωτήσεων");
    //         System.out.println("5. Εμφάνιση των απαντήσεων ενός αξιολογούμενου");
    //         System.out.println("6. Εμφάνιση το πλήθος των σωστών απαντήσεων ανά αξιολογούμενο");
    //         System.out.println("7. Υπολογισμός του ποσοστού σωστών απαντήσεων για κάθε ερώτηση");
    //         System.out.println("8. Εμφάνιση του ποσοστού των σωστών απαντήσεων ανά αξιολογούμενο");
    //         System.out.println("0. Έξοδος");
    //         System.out.print("Επιλογή: ");
            
    //         int choice = scanner.nextInt();
    //         scanner.nextLine();  // consume the newline
            
    //         switch (choice) {
    //             case 1:
    //             addNewParticipant(scanner);
    //             break;
    //             case 2:
    //             addNewQuestion(scanner);
    //             break;
    //             case 3:
    //             addNewAnswer(scanner);
    //             break;
    //             case 4:
    //             displayQuestions();
    //             break;
    //             case 5:
    //             displayParticipantAnswers(scanner);
    //             break;
    //             case 6:
    //             displayCorrectAnswersCountPerParticipant();
    //             break;
    //             case 7:
    //             calculateCorrectAnswersPercentagePerQuestion();
    //             break;
    //             case 8:
    //             displayCorrectAnswersPercentagePerParticipant();
    //             break;
    //             case 0:
    //             System.exit(0);
    //             break;
    //             default:
    //             System.out.println("Εσφαλμένη επιλογή. Δοκιμάστε ξανά.");
    //         }
    //     }
    // }

}