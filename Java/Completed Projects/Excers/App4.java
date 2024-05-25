import java.text.DecimalFormat;
import java.util.Scanner;

class App4 {
	
	public static void main(String args[]){
	
		// Fill your code here
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients of the quadratic equation:");
        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double c = scanner.nextDouble();


        double discriminant = b * b - 4 * a * c;

        DecimalFormat decimalFormat = new DecimalFormat("0.000");

        if (discriminant < 0) {
            System.out.println("The equation has no real solutions.");
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("Root 1: " + decimalFormat.format(root1));
            System.out.println("Root 2: " + decimalFormat.format(root2));
        }

        scanner.close();
	}
		
}


