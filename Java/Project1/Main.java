public class Main {
    public static void main(String[] args) {
        // Test Evaluator class
        Evaluator evaluator = new Evaluator("E001", "John Doe", "Doe", "John");
        System.out.println("Evaluator: " + evaluator.getName() + " " + evaluator.getSurname());

        // Test Question classes (replace with actual logic for each question type)
        Question multipleChoiceQuestion = new MultipleChoiceQuestion("Q001", "What is 2 + 2?");
        Question singleWordAnswerQuestion = new SingleWordAnswerQuestion("Q002", "What is the capital of France?");
        Question sentenceCompletionQuestion = new SentenceCompletionQuestion("Q003", "Complete the sentence: The quick brown ____ jumps over the lazy ____.");

        // Display descriptions of questions
        System.out.println("Multiple Choice Question: " + multipleChoiceQuestion.getDescription());
        System.out.println("Single Word Answer Question: " + singleWordAnswerQuestion.getDescription());
        System.out.println("Sentence Completion Question: " + sentenceCompletionQuestion.getDescription());
    
    }
}
