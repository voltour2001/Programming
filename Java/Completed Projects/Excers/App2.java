import java.util.Scanner;

class App2 {
	
	public static long calc(int n){
		if(n==0){
			return 1;
		}else{
			return n*calc(n-1);
		}
	}

		
  	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
        int num = sc.nextInt(); // Read an integer input from the user
        
        // Call the calc method directly using the class name
        long result = calc(num);
        
        // Print the result
        System.out.println(result);
   	}

}






