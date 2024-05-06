import java.util.List;

public class Apples extends Fruits {
    private static int totalApples;
    private String type;
    private List<String> id;

    public Apples(String type, List<String> id, boolean ripe) {
        super(ripe);
        this.type = type;
        this.id = id;
        totalApples++;
    }

    public void printDetails() {
        System.out.println("Type: " + type);

        System.out.println("Total Apples: " + totalApples); // Accessing totalFruits from Fruits class
        System.out.println("Ripe: " + isRipe()); // Accessing ripe status from Fruits class
        for (String string : id) {
            System.out.println(string);
        }
    }
}
