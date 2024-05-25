// Using BigInteger Class because 
// it was unable to calculate numbers more than 64bits

import java.math.BigInteger;
import java.util.Scanner;

class App1 {
	private int number;
	private int i=0;
	App1(int number){
		this.number = number;
	}

	public BigInteger calculateFactorial(){
		number = number - i;
		if (number == 0){
			return BigInteger.ONE;
		}else{
			i=1;
			return BigInteger.valueOf(number).multiply(calculateFactorial());
		}
	}
		
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();

		App1 x = new App1(num);
		System.out.println(x.calculateFactorial());
		
	}
}
