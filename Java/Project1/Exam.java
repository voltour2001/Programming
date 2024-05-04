import java.util.*;

public class Exam {
    private List<Question> questions;
    private List<Evaluatee> evaluatees;

    public Exam() {
        questions = new ArrayList<>();
        evaluatees = new ArrayList<>();
    }

    // Methods to add questions and evaluatees
    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addEvaluatee(Evaluatee evaluatee) {
        evaluatees.add(evaluatee);
    }

    // Methods to retrieve information about questions and evaluatees
    public List<Question> getQuestions() {
        return questions;
    }

    public List<Evaluatee> getEvaluatees() {
        return evaluatees;
    }

    // Calculate scores for evaluatees and questions
    public int calculateScore(Evaluatee evaluatee) {
        int score = 0;
        Map<Question, String> answers = evaluatee.getAnswers();
        for (Question question : answers.keySet()) {
            if (question.isCorrectAnswer(answers.get(question))) {
                score++;
            }
        }
        return score;
    }

    public double calculatePercentage(Evaluatee evaluatee) {
        return ((double) calculateScore(evaluatee) / questions.size()) * 100;
    }

    public double calculateQuestionPercentage(Question question) {
        int correctAnswers = 0;
        for (Evaluatee evaluatee : evaluatees) {
            if (question.isCorrectAnswer(evaluatee.getAnswers().get(question))) {
                correctAnswers++;
            }
        }
        return ((double) correctAnswers / evaluatees.size()) * 100;
    }
}
