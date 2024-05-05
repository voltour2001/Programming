public class Main {
    public static void main(String[] args) {
        // Create apples
        Apples x1 = new Apples("Granny Smith", "Green", 150.0, true);    
        Apples x2 = new Apples("Jucy Red", "Red", 150.0, true);    

        //x2.printDetails();

        Berries b1 = new Berries("Blue Berries", "Black", 10.0, true);

        b1.printDetails();

        Fruits.printTotalFruits();
    }
}
