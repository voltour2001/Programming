import javax.swing.tree.TreeNode;

public class WordFrequency {

    private String word;
    private int count; // αριθμος εμφανισεων

    public WordFrequency(String word) {
        this.word = word;
        this.count = 1;
    }

    public String key() {
        return word;
    }

    public void addCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

    public int setCount(int c) {
        return c;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }

}
