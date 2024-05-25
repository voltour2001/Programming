import java.text.DecimalFormat;

class Account {

    // Static Interest Rate
    private final double interestRate = 0.015; // 1.5%

    // Variables 
    private String customerName;
    private String accountNumber;
    private double balance;  
	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

	Account(String accountNumber, String customerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = initialBalance;
    }

   	double Deposit (double Amount){
		if (Amount > 0) {
			balance = balance + Amount;
		}else{
			System.out.println("Invalid amount");
		}
		return balance;
	}

	double Withdraw (double Amount) {
		if (Amount > 0 && Amount <= balance) {
			balance -= Amount;
		}else{
			System.out.println("Error: Invalid amount");
		}		
		return balance;
   	}

	String getBalance (){
		String formattedBalance = decimalFormat.format(balance); 	
		return formattedBalance;
	}

	double addInterest() {
		double interest = balance * interestRate;
		balance += interest;
		return balance;
	}
	

   	public String toString(){

		String formattedBalance = decimalFormat.format(balance); 	

		String x = "Account Number: " + accountNumber + "\n" +
				"Customer Name: " + customerName + "\n" +
				"Balance: " +  formattedBalance +"\n";		

		return x;
   	}
}
