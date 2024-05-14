import java.util.List;

public class SingleWordAnswerQuestion extends Question {

    //! Constructor
    public SingleWordAnswerQuestion(String code, String description) {
        super(code, description);
        //* Additional initialization if needed
    }
    
    @Override
    public boolean isCorrect(List<String> userResponse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCorrect'");
    }
    
}