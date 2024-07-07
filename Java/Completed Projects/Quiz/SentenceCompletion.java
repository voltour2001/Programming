import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentenceCompletion extends Question {
    private List<String> words;
    private List<String> correctOrder;

    public SentenceCompletion(String code, String description, List<String> words, List<String> correctOrder) {
        super(code, description);
        this.words = words;
        this.correctOrder = correctOrder;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getCorrectOrder() {
        return correctOrder;
    }

    public static List<SentenceCompletion> createFromUserInput() {
        List<SentenceCompletion> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Code
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();

        // Description
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        // Number of words
        System.out.print("How many words: ");
        int numberOfWords = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Words
        System.out.println("Enter Words: ");
        List<String> words = new ArrayList<>();
        for (int i = 0; i < numberOfWords; i++) {
            System.out.print("Word with number " + i + ": ");
            words.add(scanner.nextLine());
        }

        // Correct Order
        System.out.println("Enter Correct Order of each word: ");
        List<String> correctOrder = new ArrayList<>();
        for (int i = 0; i < numberOfWords; i++) {
            System.out.print("Correct Word for the place " + i + ": ");
            correctOrder.add(scanner.nextLine());
        }

        SentenceCompletion question = new SentenceCompletion(code, description, words, correctOrder);
        questions.add(question);

        return questions;
    }

    @Override
    public boolean isCorrect(List<String> userResponse) {
        if (userResponse.size() != correctOrder.size()) {
            return false;
        }
        for (int i = 0; i < userResponse.size(); i++) {
            if (!userResponse.get(i).equalsIgnoreCase(correctOrder.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("Code: " + getCode());
        System.out.println("Description: " + getDescription());
        System.out.println("Words to arrange:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<SentenceCompletion> questions = SentenceCompletion.createFromUserInput();
        for (SentenceCompletion question : questions) {
            question.display();
            List<String> userResponse = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your answer in correct order:");
            for (int i = 0; i < question.getWords().size(); i++) {
                userResponse.add(scanner.nextLine());
            }
            System.out.println("Your answer is " + (question.isCorrect(userResponse) ? "correct" : "incorrect"));
        }
    }
}