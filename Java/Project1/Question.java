import java.util.ArrayList;
import java.util.List;

public abstract class Question {
    private String code;
    private String description;

    public Question(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static List<Integer> isCorrect(List<List<Integer>> correctChoices, List<List<Integer>> userChoices) {
        List<Integer> wrongIndices = new ArrayList<>();
    
        // Iterate over each question
        for (int i = 0; i < correctChoices.size(); i++) {
            List<Integer> correct = correctChoices.get(i);
            List<Integer> user = userChoices.get(i);
    
            // Check if the number of choices is different
            if (correct.size() != user.size()) {
                wrongIndices.add(i);
                continue; // Skip further comparison for this question
            }
    
            // Compare each element in the correct and user choice sublists
            boolean allCorrect = true;
            for (int j = 0; j < correct.size(); j++) {
                if (!correct.get(j).equals(user.get(j))) {
                    allCorrect = false;
                    break; // Exit loop if any choice is incorrect
                }
            }
    
            // If all choices are correct, add the index to the list of wrong indices
            if (!allCorrect) {
                wrongIndices.add(i);
            }
        }
    
        return wrongIndices;
    }
    

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
