import java.util.Scanner;

class App6  {

	public static void main(String args[]) {
		
    	Account Account1 = new Account ("GR100", "TOGONTZH MARIA", 1000 );

		Scanner in = new Scanner(System.in);
    		
		for (;;){
			System.out.println ("\n---------------");
			System.out.println ("1. Deposit");
			System.out.println ("2. Withdraw");
			System.out.println ("3. Account Details");
			System.out.println ("4. Add Interest");
			System.out.println ("0. Exit");
			System.out.println ("---------------");
			System.out.print ("> ");
			int choice = in.nextInt();
			if (choice == 1){
				
				System.out.print("Deposit ... \n");

				//* Display Account information
				System.out.println(Account1.toString());
				
				//* Enter the Diposit amount
				System.out.print("Amount: ");
				double amount = in.nextDouble();
				Account1.Deposit(amount);
				
				System.out.println("New Balance : " + Account1.getBalance());
			}
			else if (choice == 2) {
				
				System.out.print("Withdraw ... \n");
				
				//* Display Account information
				System.out.println(Account1.toString());
				
				//* Enter the Withdrawl amount
				System.out.print("Amount: ");
				double amount = in.nextDouble();
				Account1.Withdraw(amount);
				
				System.out.println("New Balance : " + Account1.getBalance());

			}
			else if (choice == 3) {
				System.out.println(Account1.toString());
			}
			else if (choice == 4) {
				
				Account1.addInterest();
				System.out.println(Account1.toString());
			}
			else if (choice == 0) break;
		}

   }

}