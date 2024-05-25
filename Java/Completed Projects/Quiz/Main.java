import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        List<SentenceCompletion> SentenceCompletionQuestions = new ArrayList<>();
        SentenceCompletionQuestions.addAll(premadeSentenceCompletionQuestions());

        questions.addAll(MultipleChoiceQuestions);
        questions.addAll(SingleWordQuestions);
        questions.addAll(SentenceCompletionQuestions);


        List<Answers> answersList = new ArrayList<>();


        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1: New EvaluatedParticipant");
            System.out.println("2: New Question");
            System.out.println("3: New Answer");
            System.out.println("4: Display all questions");
            System.out.println("5: Display answers of participant");
            System.out.println("6: Display correct answers count for each participant");
            System.out.println("7: Display percentage of correct answers per question");
            System.out.println("8: Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    participants.add(createNewParticipant(scanner, participants));
                    break;
                case 2:
                    questions.addAll(createNewQuestion(scanner, questions));
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
                    displayCorrectAnswersOfParticipant(scanner, participants, answersList, questions);
                    break;
                case 7:
                    displayCorrectAnswerPercentagePerQuestion(questions, answersList);
                    break;
                case 8:
                    exit = true;
                    break;
                
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }


    //! Initialize questions and participants
    private static List<MultipleChoice> premadeMultipleChoiceQuestions() {
        List<MultipleChoice> questions = new ArrayList<>();

        String code1 = "101";
        String description1 = "Which of the following are prime numbers?";
        List<String> answerOptions1 = List.of("2", "4", "5", "9");
        List<Integer> correctChoices1 = List.of(1, 3); // Assuming correct answers are Option A and Option B
        questions.add(new MultipleChoice(code1, description1, answerOptions1, correctChoices1));

        String code2 = "102";
        String description2 = "Which of the following programming languages are statically typed?";
        List<String> answerOptions2 = List.of("Python", "Java", "JavaScript", "C++");
        List<Integer> correctChoices2 = List.of(2,4); // Assuming correct answer is Option G
        questions.add(new MultipleChoice(code2, description2, answerOptions2, correctChoices2));

        String code3 = "103";
        String description3 = "Which of the following are planets in our solar system?";
        List<String> answerOptions3 = List.of("Earth", "Proxima Centauri", "Jupiter", "Andromeda");
        List<Integer> correctChoices3 = List.of(1,3); // Assuming correct answer is Option L
        questions.add(new MultipleChoice(code3, description3, answerOptions3, correctChoices3));

        return questions;
    }

    private static List<SingleWord> premadeSingleWordQuestions() {
        List<SingleWord> questions = new ArrayList<>();

        String code1 = "201";
        String description1 = "What is the chemical symbol for water?";
        String correctAnswer1 = "H2O";
        questions.add(new SingleWord(code1, description1, correctAnswer1));

        String code2 = "202";
        String description2 = "What is the capital of France?";
        String correctAnswer2 = "Paris";
        questions.add(new SingleWord(code2, description2, correctAnswer2));

        String code3 = "203";
        String description3 = "Which element has the atomic number 1?";
        String correctAnswer3 = "Hydrogen";
        questions.add(new SingleWord(code3, description3, correctAnswer3));

        return questions;
    }
    
    private static List<SentenceCompletion> premadeSentenceCompletionQuestions() {
        List<SentenceCompletion> questions = new ArrayList<>();

        String code1 = "301";
        String description1 = "The process by which plants convert sunlight into energy is called ?. It involves the pigment ?.";
        List<String> words1 = List.of("Photosynthesis", "Chlorophyll");
        List<String> correctOrder1 = List.of("Photosynthesis", "Chlorophyll");
        questions.add(new SentenceCompletion(code1, description1, words1, correctOrder1));
        
        String code2 = "302";
        String description2 = "In a right triangle, the side opposite the right angle is called the ?. The other two sides are called the ?.";
        List<String> words2 = List.of("Hypotenuse", "Legs");
        List<String> correctOrder2 = List.of("Hypotenuse", "Legs");
        questions.add(new SentenceCompletion(code2, description2, words2, correctOrder2));
        
        String code3 = "303";
        String description3 = "The largest planet in our solar system is ?. It is known for its prominent storm called the ?.";
        List<String> words3 = List.of("Jupiter", "Great Red Spot");
        List<String> correctOrder3 = List.of("Jupiter", "Great Red Spot");
        questions.add(new SentenceCompletion(code3, description3, words3, correctOrder3));

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

    //! Other methods
    private static void displayCorrectAnswerPercentagePerQuestion(List<Question> questions, List<Answers> answersList) {
        Map<String, Integer> correctAnswerCounts = new HashMap<>();
        Map<String, Integer> totalAnswerCounts = new HashMap<>();
    
        // Initialize counts for all questions
        for (Question question : questions) {
            correctAnswerCounts.put(question.getCode(), 0);
            totalAnswerCounts.put(question.getCode(), 0);
        }
    
        // Calculate counts
        for (Answers answers : answersList) {
            for (Map.Entry<String, List<String>> entry : answers.getParticipantAnswers().entrySet()) {
                String questionCode = entry.getKey();
                List<String> userResponse = entry.getValue();
                Question question = questions.stream()
                        .filter(q -> q.getCode().equals(questionCode))
                        .findFirst()
                        .orElse(null);
                if (question != null) {
                    totalAnswerCounts.put(questionCode, totalAnswerCounts.get(questionCode) + 1);
                    if (question.isCorrect(userResponse)) {
                        correctAnswerCounts.put(questionCode, correctAnswerCounts.get(questionCode) + 1);
                    }
                }
            }
        }
    
        // Calculate percentages
        List<Map.Entry<String, Double>> percentageList = new ArrayList<>();
        for (String questionCode : correctAnswerCounts.keySet()) {
            int correctCount = correctAnswerCounts.get(questionCode);
            int totalCount = totalAnswerCounts.get(questionCode);
            double percentage = (totalCount > 0) ? ((double) correctCount / totalCount) * 100 : 0;
            percentageList.add(new AbstractMap.SimpleEntry<>(questionCode, percentage));
        }
    
        // Sort by percentage in descending order
        percentageList.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));
    
        // Calculate the maximum length of percentage strings
        int maxLength = percentageList.stream()
                .map(entry -> String.format("(%.2f%%) ", entry.getValue()).length())
                .max(Integer::compareTo)
                .orElse(0);
    
        // Print results
        System.out.println("\nPercentage of Correct Answers per Question:");
        for (Map.Entry<String, Double> entry : percentageList) {
            String questionCode = entry.getKey();
            double percentage = entry.getValue();
            Question question = questions.stream()
                    .filter(q -> q.getCode().equals(questionCode))
                    .findFirst()
                    .orElse(null);
            if (question != null) {
                String percentageString = String.format("(%.2f%%) ", percentage);
                System.out.printf("%-" + maxLength + "sQuestion: %s\n", percentageString, question.getDescription());
            }
        }
        System.out.println();
    }
    
    private static void displayCorrectAnswersOfParticipant(Scanner scanner, List<EvaluatedParticipant> participants, List<Answers> answersList, List<Question> questions) {
        // Print all participants
        System.out.println("\nAvailable Participants:");
        for (EvaluatedParticipant participant : participants) {
            System.out.println(participant.toString());
        }
    
        System.out.print("\nEnter Participant Code: ");
        String participantCode = scanner.nextLine();
    
        // Find the participant
        EvaluatedParticipant participant = participants.stream()
                .filter(p -> p.getCode().equals(participantCode))
                .findFirst()
                .orElse(null);
    
        if (participant != null) {
            System.out.println("\nCorrect Answers of Participant " + participant.getFirstName() + " " + participant.getLastName() + ":");
    
            // Find answers for the participant
            Answers participantAnswers = answersList.stream()
                    .filter(a -> a.getParticipantCode().equals(participantCode))
                    .findFirst()
                    .orElse(null);
    
            if (participantAnswers != null) {
                System.out.println();
                // Iterate over the participant's answers and check correctness
                for (Map.Entry<String, List<String>> entry : participantAnswers.getParticipantAnswers().entrySet()) {
                    String questionCode = entry.getKey();
                    List<String> answer = entry.getValue();
                    Question question = questions.stream()
                            .filter(q -> q.getCode().equals(questionCode))
                            .findFirst()
                            .orElse(null);
                    if (question != null) {
                        boolean isCorrect = question.isCorrect(answer);
                        if (isCorrect) {
                            System.out.println("Question: " + question.getDescription() + ", Answer: " + answer);
                        }
                    }
                }
            } else {
                System.out.println("No answers found for this participant.");
            }
        } else {
            System.out.println("Participant not found.");
        }
        System.out.println();
    }
 
    private static class ParticipantCorrectCount {
        private final EvaluatedParticipant participant;
        private final int correctCount;

        public ParticipantCorrectCount(EvaluatedParticipant participant, int correctCount) {
            this.participant = participant;
            this.correctCount = correctCount;
        }

        public EvaluatedParticipant getParticipant() {
            return participant;
        }

        public int getCorrectCount() {
            return correctCount;
        }
    }
    
    private static EvaluatedParticipant createNewParticipant(Scanner scanner, List<EvaluatedParticipant> participants) {

        System.out.print("Existing Participant Codes: ");
        for (EvaluatedParticipant participant : participants) {
            System.out.print("[" + participant.getCode() + "]" + ", ");
        }

        System.out.print("\nEnter Participant Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Participant First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Participant Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("\nAdded new participant succesfully.\n");
        return new EvaluatedParticipant(code, lastName, firstName);
    }
    
    private static List<Question> createNewQuestion(Scanner scanner, List<Question> questions) {
        // Create sets to store existing codes for each type of question
        Set<String> multipleChoiceCodes = new HashSet<>();
        Set<String> singleWordCodes = new HashSet<>();
        Set<String> sentenceCompletionCodes = new HashSet<>();
    
        // Populate the sets with existing codes
        for (Question question : questions) {
            if (question instanceof MultipleChoice) {
                multipleChoiceCodes.add(question.getCode());
            } else if (question instanceof SingleWord) {
                singleWordCodes.add(question.getCode());
            } else if (question instanceof SentenceCompletion) {
                sentenceCompletionCodes.add(question.getCode());
            }
        }
            // Print existing codes for each type
        
        System.out.println();
        System.out.println("Select Question Type:");
        System.out.println("1: Multiple Choice");
        System.out.println("2: Single Word");
        System.out.println("3: Sentence Completion");
        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        List<Question> newQuestions = new ArrayList<>();
    
        switch (choice) {
            case 1:
                System.out.println();
                System.out.println("Existing Multiple Choice Codes     : " + multipleChoiceCodes + "\n");
                
                newQuestions.addAll(MultipleChoice.createFromUserInput());
                break;
            case 2:
                
                System.out.println();
                System.out.println("Existing Single Word Codes         : " + singleWordCodes+ "\n");
                newQuestions.addAll(SingleWord.createFromUserInput());
                break;
            case 3:
                System.out.println();
                System.out.println("Existing Sentence Completion Codes : " + sentenceCompletionCodes+ "\n");
                newQuestions.addAll(SentenceCompletion.createFromUserInput());
                break;
            default:
                System.out.println("Invalid choice! Please enter 1, 2 or 3.");
        }
    
        return newQuestions;
    }
    
    private static void addNewAnswer(Scanner scanner, List<EvaluatedParticipant> participants, List<Question> questions, List<Answers> answersList) {
        
        System.out.println();
        //* Print all participants
        for (EvaluatedParticipant participant : participants) {
            System.out.println(participant.toString());
        }
        System.out.println();

        //* Select participant
        System.out.print("Enter Participant Code: ");
        String participantCode = scanner.nextLine();

        //* Filter Participant Stream to find the participant
        EvaluatedParticipant participant = participants.stream().filter(p -> p.getCode().equals(participantCode)).findFirst().orElse(null);

        System.out.println();
        if (participant == null) {
            System.out.println("Participant not found.\n");
            
            return;
        }
        
        //* Print all questions
        System.out.println("Select Question:");
        System.out.println();
        for (Question question : questions) {
            System.out.println(question.getCode() + ": " + question.getDescription());
        }

        //* Select question
        System.out.print("\nEnter Question Code: ");
        String questionCode = scanner.nextLine();

        //* Filter Question Stream to find the question
        Question question = questions.stream().filter(q -> q.getCode().equals(questionCode)).findFirst().orElse(null);

        if (question == null) {
            System.out.println("Question not found.\n");
            return;
        }
        System.out.println();

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

        System.out.println("\nAnswer added successfully.\n");
    }

    private static void displayAllQuestions(List<Question> questions) {
        System.out.println("All Questions:");
        for (Question question : questions) {
            question.display();
        }
        System.out.println();
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