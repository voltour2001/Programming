import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> answerChoices;
    private List<Integer> correctAnswerIndices;

    public MultipleChoiceQuestion(String code, String description, List<String> answerChoices, List<Integer> correctAnswerIndices) {
        super(code, description);
        this.answerChoices = answerChoices;
        this.correctAnswerIndices = correctAnswerIndices;
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        // Implementation for multiple choice questions
        // Check if the provided answer indices match the correct answer indices
        return false;
    }
}
