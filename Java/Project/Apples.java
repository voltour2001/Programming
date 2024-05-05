public class Apples extends Fruits {
    private static int totalApples;
    private String type;
    private String color;
    private double weight;

    public Apples(String type, String color, double weight, boolean ripe) {
        super(ripe);
        this.type = type;
        this.color = color;
        this.weight = weight;
        totalApples++;
    }

    public void printDetails() {
        System.out.println("Type: " + type);
        System.out.println("Color: " + color);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Total Apples: " + totalApples); // Accessing totalFruits from Fruits class
        System.out.println("Ripe: " + isRipe()); // Accessing ripe status from Fruits class
    }
}
