import java.util.List;

public class Evaluator extends Question {
    private String name,surname;
    public Evaluator(String code, String description, String name, String surname) {
        super(code, description);
        this.name = name;
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    @Override
    public boolean isCorrect(List<String> userResponse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCorrect'");
    }
}