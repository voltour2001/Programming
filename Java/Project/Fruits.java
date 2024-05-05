public class Fruits {
    protected static int totalFruits; // Total fruits
    private boolean ripe;

    public Fruits(boolean ripe) {
        this.ripe = ripe;
        totalFruits++;
    }

    public static void printTotalFruits() {
        System.out.println("Total fruits: " + totalFruits);
    }

    public boolean isRipe() {
        return ripe;
    }
}
