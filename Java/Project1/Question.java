public abstract class Question extends Exam {
    //! Constructor
    public Question(String code, String description) {
        super(code, description);
    }

    //* Abstract method to be implemented by subclasses
    public abstract boolean isCorrect(Object response);
}

class MultipleChoiceQuestion extends Question {
    
    //* Additional attributes and methods specific to MultipleChoiceQuestion
    

    //! Constructor
    public MultipleChoiceQuestion(String code, String description) {
        super(code, description);
        
        //* Additional initialization if needed
    
    }

    public boolean isCorrect(Object response) {
        
        //todo Implement logic to check if the response is correct for a multiple-choice question
        //todo Replace with correct logic

        return false; 
    }
}

class SingleWordAnswerQuestion extends Question {

    //! Constructor
    public SingleWordAnswerQuestion(String code, String description) {
        super(code, description);
        //* Additional initialization if needed
    }
    
    public boolean isCorrect(Object response) {

        //todo Implement logic to check if the response is correct for a single-word answer question
        //todo Replace with correct logic
        
        return false;
    }
}

class SentenceCompletionQuestion extends Question {
    
    //! Constructor
    public SentenceCompletionQuestion(String code, String description) {
        super(code, description);
        //* Additional initialization if needed
    }
    public boolean isCorrect(Object response) {

        //todo Implement logic to check if the response is correct for a single-word answer question
        //todo Replace with correct logic
        
        return false;
    }
}