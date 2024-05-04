public class SingleAnswerQuestion extends Question {
    private String correctAnswer;

    public SingleAnswerQuestion(String code, String description, String correctAnswer) {
        super(code, description);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        // Implementation for single answer questions
        // Check if the provided answer matches the correct answer
        return false;
    }
}
