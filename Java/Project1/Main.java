import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<EvaluatedParticipant> participants = new ArrayList<>();
        participants.addAll(initializeParticipants());

        List<Question> questions = new ArrayList<>();

        //! Initialize premade questions
        List<MultipleChoice> MultipleChoiceQuestions = new ArrayList<>();
        MultipleChoiceQuestions.addAll(premadeMultipleChoiceQuestions());

        List<SingleWord> SingleWordQuestions = new ArrayList<>();
        SingleWordQuestions.addAll(premadeSingleWordQuestions());

        questions.addAll(MultipleChoiceQuestions);
        questions.addAll(SingleWordQuestions);


        List<Answers> answersList = new ArrayList<>();


        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1: New EvaluatedParticipant");
            System.out.println("2: New Question");
            System.out.println("3: New Answer");
            System.out.println("4: Display all questions");
            System.out.println("5: Display answers of participant");
            System.out.println("6: Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    participants.add(createNewParticipant(scanner));
                    break;
                case 2:
                    questions.addAll(createNewQuestion(scanner));
                    break;
                case 3:
                    addNewAnswer(scanner, participants, questions, answersList);
                    break;
                case 4:
                    displayAllQuestions(questions);
                    break;
                case 5:
                    displayParticipantAnswers(scanner, participants, answersList);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }


    //! Create a premade question template
    private static List<MultipleChoice> premadeMultipleChoiceQuestions() {
        List<MultipleChoice> questions = new ArrayList<>();

        String code1 = "101";
        String description1 = "x^2 = 25";
        List<String> answerOptions1 = List.of("5", "-5", "20", "25");
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
        String description1 = "Another Word for Sun";
        String correctAnswer1 = "star";
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
    
    private static List<EvaluatedParticipant> initializeParticipants() {

        List<EvaluatedParticipant> participants = new ArrayList<>();

        EvaluatedParticipant participant1 = new EvaluatedParticipant("001", "Skouras", "Spyros");
        EvaluatedParticipant participant2 = new EvaluatedParticipant("002", "Bobs", "James" );
        EvaluatedParticipant participant3 = new EvaluatedParticipant("003", "Papadopoulos", "thodoris" );
        EvaluatedParticipant participant4 = new EvaluatedParticipant("004", "Giannakou", "Michalis");

        

        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
        participants.add(participant4);
    
        return participants;
    }

    private static EvaluatedParticipant createNewParticipant(Scanner scanner) {
        System.out.print("Enter Participant Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Participant First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Participant Last Name: ");
        String lastName = scanner.nextLine();
        return new EvaluatedParticipant(code, lastName, firstName);
    }

    private static List<Question> createNewQuestion(Scanner scanner) {
        System.out.println("Select Question Type:");
        System.out.println("1: Multiple Choice");
        System.out.println("2: Single Word");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        List<Question> newQuestions = new ArrayList<>();

        switch (choice) {
            case 1:
                newQuestions.addAll(MultipleChoice.createFromUserInput());
                break;
            case 2:
                newQuestions.addAll(SingleWord.createFromUserInput());
                break;
            default:
                System.out.println("Invalid choice! Please enter 1 or 2.");
        }

        return newQuestions;
    }

    private static void addNewAnswer(Scanner scanner, List<EvaluatedParticipant> participants,
                                 List<Question> questions, List<Answers> answersList) {
        
        //* Print all participants
        for (EvaluatedParticipant participant : participants) {
            System.out.println(participant.toString());
        }
        
        //* Select participant
        System.out.print("Enter Participant Code: ");
        String participantCode = scanner.nextLine();

        //* Filter Participant Stream to find the participant
        EvaluatedParticipant participant = participants.stream().filter(p -> p.getCode().equals(participantCode)).findFirst().orElse(null);

        if (participant == null) {
            System.out.println("Participant not found.");
            return;
        }

        //* Print all questions
        System.out.println("Select Question:");
        for (Question question : questions) {
            System.out.println(question.getCode() + ": " + question.getDescription());
        }

        //* Select question
        System.out.print("Enter Question Code: ");
        String questionCode = scanner.nextLine();

        //* Filter Question Stream to find the question
        Question question = questions.stream().filter(q -> q.getCode().equals(questionCode)).findFirst().orElse(null);

        if (question == null) {
            System.out.println("Question not found.");
            return;
        }

        //* Display the question
        question.display();
        System.out.print("Enter Answer: ");
        String answer = scanner.nextLine();

        // Find or create Answers object for the participant
        Answers participantAnswers = answersList.stream().filter(a -> a.getParticipantCode().equals(participantCode)).findFirst().orElseGet(() -> {
                    Answers newAnswers = new Answers(participantCode);
                    answersList.add(newAnswers);
                    return newAnswers;
                });

        // Add the answer
        participantAnswers.addAnswer(questionCode, answer);

        System.out.println("Answer added successfully.");
    }

    private static void displayAllQuestions(List<Question> questions) {
        System.out.println("All Questions:");
        for (Question question : questions) {
            question.display();
        }
    }

    private static void displayParticipantAnswers(Scanner scanner, List<EvaluatedParticipant> participants, List<Answers> answersList) {
        

        // Print all participants
        System.out.println();
        for (EvaluatedParticipant participant : participants) {
            System.out.println(participant.toString());
        }

        System.out.print("\nEnter Participant Code: ");
        String participantCode = scanner.nextLine();

        // Find the participant
        EvaluatedParticipant participant = participants.stream().filter(p -> p.getCode().equals(participantCode)).findFirst().orElse(null);

        if (participant != null) {
            System.out.println("\nAnswers of Participant " + participant.getFirstName() + " " + participant.getLastName() + ":");
            
            // Find answers for the participant
            // Stream
            Answers participantAnswers = answersList.stream().filter(a -> a.getParticipantCode().equals(participantCode)).findFirst().orElse(null);

            if (participantAnswers != null) {

                System.out.println();
                // Iterate over the participant's answers
                for (Map.Entry<String, List<String>> entry : participantAnswers.getParticipantAnswers().entrySet()) {
                    String questionCode = entry.getKey();
                    List<String> answer = entry.getValue();
                    System.out.println("Question: " + questionCode + ", Answer: " + answer + "\n");
                }
            } else {
                System.out.println("No answers found for this participant.\n");
            }
        } else {
            System.out.println("\nParticipant not found.\n");
        }
        }



}