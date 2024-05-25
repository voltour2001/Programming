import java.util.ArrayList;
import java.util.List;

public abstract class Question {
    private String code;
    private String description;

    public Question(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    
    public String getCode() {
        return code;
    }
    
    public String getDescription() {
        return description;
    }
    
    public abstract boolean isCorrect(List<String> userResponse);
    public abstract void display();
}
