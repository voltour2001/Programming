import java.util.List;

public class FillInTheBlanksQuestion extends Question {
    private List<String> correctOrder;

    public FillInTheBlanksQuestion(String code, String description, List<String> correctOrder) {
        super(code, description);
        this.correctOrder = correctOrder;
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        // Implementation for fill in the blanks questions
        // Check if the provided answer matches the list of words in correct order
        return false;
    }
}
