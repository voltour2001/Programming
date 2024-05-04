import java.util.*;

public class Evaluatee {
    private String name;
    private Map<Question, String> answers;

    public Evaluatee(String name) {
        this.name = name;
        answers = new HashMap<>();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public Map<Question, String> getAnswers() {
        return answers;
    }

    // Method to add answers for a question
    public void addAnswer(Question question, String answer) {
        answers.put(question, answer);
    }
}
