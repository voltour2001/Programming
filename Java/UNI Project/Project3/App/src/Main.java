import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.load("src/hello.txt");

        System.out.println("Inserting words into BST...");
        // tree.insert("apple");
        // tree.insert("banana");
        // tree.insert("apple");
        // tree.insert("cherry");
        // tree.insert("date");
        // tree.insert("banana");
        // tree.insert("apple");
        // tree.insert("fig");
        // tree.insert("grape");

        System.out.println("\nSearching for words...");
        // testSearch(tree, "you");
        testSearch(tree, "joke");
        testSearch(tree, "fine");
        testSearch(tree, "like"); // Not inserted

        System.out.println("\nWord frequencies:");
        testFrequency(tree, "you");
        testFrequency(tree, "how");
        testFrequency(tree, "nope");
        testFrequency(tree, "will");

        System.out.println("\nTotal words in BST: " + tree.getNumTotalWords());
        System.out.println("Distinct words in BST: " + tree.getNumDistinctWords());

        System.out.println("\nWord with highest frequency: " + tree.getMaxFrequency().key());

        System.out.println("\nAdding stop words: 'the', 'is', 'a'");
        tree.addStopWord("the");
        tree.addStopWord("is");
        tree.addStopWord("a");

        System.out.println("Inserting stop words (should be ignored)...");
        tree.insert("the");
        tree.insert("is");
        tree.insert("a");

        System.out.println("Distinct words after stop words insertion: " + tree.getNumDistinctWords());
        testSearch(tree, "you");
        tree.removeStopWord("the");
        System.out.println("\nRemoving 'you' from BST...");
        tree.remove("you");
        testSearch(tree, "you"); // Should be null
        testSearch(tree, "the");
        System.out.println("\nTotal words after removal: " + tree.getNumTotalWords());
        System.out.println("Distinct words after removal: " + tree.getNumDistinctWords());

        System.out.println("\nPrinting BST by word order:");
        tree.printTreeByWord(System.out);

        System.out.println("\nPrinting BST by frequency:");
        tree.printΤreeByFrequency(System.out);
    }

    private static void testSearch(BST tree, String word) {
        WordFrequency result = tree.search(word);
        if (result != null) {
            System.out.println("Found '" + word + "' with frequency: " + result.getCount());
        } else {
            System.out.println("'" + word + "' not found in BST.");
        }
    }

    private static void testFrequency(BST tree, String word) {
        int freq = tree.getFrequency(word);
        System.out.println("'" + word + "' frequency: " + freq);
    }
}
