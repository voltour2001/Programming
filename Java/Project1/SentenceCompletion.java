import java.util.List;

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

    @Override
    public boolean isCorrect(List<String> userResponse) {
        return userResponse.equals(correctOrder);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }
}
