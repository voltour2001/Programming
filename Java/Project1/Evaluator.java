public class Evaluator extends Exam {
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
}