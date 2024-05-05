public class Berries extends Fruits {
    private static int totalBerries;
    private String type;
    private String color;
    private double weight;

    public Berries(String type, String color, double weight, boolean ripe) {
        super(ripe);
        this.type = type;
        this.color = color;
        this.weight = weight;
        totalBerries++;
    }

    public static void printTotalBerries() {
        System.out.println("Total berries: " + totalBerries);
    }
    public void printDetails() {
        System.out.println("Type: " + type);
        System.out.println("Color: " + color);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Total berries: " + totalBerries);
        System.out.println("Ripe: " + isRipe());
    }
}
