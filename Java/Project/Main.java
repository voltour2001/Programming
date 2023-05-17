package Project;

public class Main{
    public static void main(String[] args) {
        
        diafimisis ad = new diafimisis(34567, "test", 169255);
        System.out.println(ad.getID());

        edipes ad2 = new edipes(101, "Description test", 12345, 5, 4, 2);
        System.out.println(ad2.getMiddle());
    }
}