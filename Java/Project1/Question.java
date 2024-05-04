public abstract class Question {
    private String code;
    private String description;

    public Question(String code, String description) {
        this.code = code;
        this.description = description;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    // Abstract method to check if an answer is correct
    public abstract boolean isCorrectAnswer(String answer);
}
