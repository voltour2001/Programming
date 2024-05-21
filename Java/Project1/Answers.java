import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answers {
    private String participantCode;
    private Map<String, List<String>> participantAnswers; // Map to store question codes and their answers

    public Answers(String participantCode) {
        this.participantCode = participantCode;
        this.participantAnswers = new HashMap<>();
    }

    public String getParticipantCode() {
        return participantCode;
    }

    public void addAnswer(String questionCode, String answer) {
        // Split the answer string by commas
        String[] answerArray = answer.split(",");
        List<String> answerList = new ArrayList<>();
        for (String ans : answerArray) {
            answerList.add(ans.trim());
        }
        // Add the answer list to the map
        participantAnswers.put(questionCode, answerList);
    }

    public List<String> getAnswer(String questionCode) {
        return participantAnswers.get(questionCode);
    }

    public Map<String, List<String>> getParticipantAnswers() {
        return participantAnswers;
    }
}
