public class EvaluatedParticipant {
    private String code;
    private String lastName;
    private String firstName;

    public EvaluatedParticipant(String code, String lastName, String firstName) {
        this.code = code;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getCode() {
        return code;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return code + ": " + firstName + " " + lastName;
    }
}
