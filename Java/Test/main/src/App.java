interface WaterBottle {
    void fillUp();
    void drink(int amount);
    int getAmount();
}

class MyWaterBottle implements WaterBottle {
    private int waterAmount;

    public MyWaterBottle() {
        this.waterAmount = 0;
    }

    public void fillUp() {
        this.waterAmount = 100;
        System.out.println("You filled up the water bottle.");
        displayAmount();
    }

    public void drink(int amount) {
        if (amount > waterAmount) {
            System.out.println("Not enough water to drink " + amount + " units.");
        } else {
            waterAmount -= amount;
            System.out.println("You drank " + amount + " units of water.");
            displayAmount();
        }
    }

    public int getAmount() {
        return waterAmount;
    }

    public void displayAmount() {
        System.out.println("Water: " + waterAmount + "%");
    }
}

// Κύρια Κλάση με τη Μέθοδο Main
public class App {
    public static void main(String[] args) {
        MyWaterBottle bottle = new MyWaterBottle();

        bottle.displayAmount();  
        bottle.fillUp();
        bottle.drink(63);
        bottle.drink(37);
        bottle.drink(20);
        bottle.fillUp();
        bottle.drink(20);
    }
}
