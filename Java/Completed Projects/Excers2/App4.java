import java.util.Scanner;

class App4 {

	public static void main (String args[]) {
		
		CustomerList list = new CustomerList();
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		for (;;) {
			System.out.println ("1. Insert Customer");
			System.out.println ("2. Lookup Customer");
			System.out.println ("3. Display List");
			System.out.println ("0. Exit");
			 
			choice = scan.nextInt();
			
			switch (choice) {
				case 1:
					String name, code;
					int day, month, year;

					System.out.print("Name: ");
					name = scan.next();
					System.out.print("Code: ");
					code = scan.next();
					System.out.print("Day: ");
					day = scan.nextInt();
					System.out.print("Month: ");
					month = scan.nextInt();
					System.out.print("Year: ");
					year = scan.nextInt();

					Customer newCustomer = new Customer(name, code, day, month, year); // Example customer data
					list.InsertCustomer(newCustomer);
					break;
				case 2:
					System.out.println("Enter code: ");
					code = scan.next();
					list.LookupCustomer(code);
					break;
				case 3:
					list.DisplayList();
					break;

				case 0:
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");
			}
		}// for

		
	} //main
	
}//App4
