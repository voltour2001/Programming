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

        //* Code
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();

        //* Description
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        //* Number of words
        System.out.print("How many words: ");
        int numberOfWords = scanner.nextInt();
        
        //* Words
        System.out.println("Enter Words: ");
        String word = scanner.nextLine();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < numberOfWords; i++) {
            System.out.print("Word with number " + i + ":");
            words.add(scanner.nextLine());
        }

        //* Correct Order
        System.out.println("Enter Correct Order of each word: ");
        List<String> correctOrder = new ArrayList<>();

        for (int i = 0; i < numberOfWords; i++) {
            System.out.print("Correct Word for the place (write the word)" + i + ": ");
            correctOrder.add(scanner.nextLine());
        }

        System.out.println();
        SentenceCompletion question = new SentenceCompletion(code, description, words, correctOrder);
        return List.of(question);    
    }
    @Override
    public boolean isCorrect(List<String> userResponse) {
        return userResponse.equals(correctOrder);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println("Code: " + getCode());
        System.out.println("Description: " + getDescription());
        
        for (String string : words) {
            System.out.println(string);

            
        }
    }
}
