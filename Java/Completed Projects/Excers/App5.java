
class App5 {
	
	public static void main(String args[]){
		
        int num = Integer.parseInt(args[0]);
        int firstTerm = 0, secondTerm = 1;
        boolean found = false;
        
        while (firstTerm <= num) {
            if (firstTerm == num) {
                found = true;
                break;
            }
            
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
			System.out.println("Fibonacci number = " + firstTerm);
        }
        
        if (found) {
            System.out.println(num + " is a Fibonacci number.");
        } else {
            System.out.println(num + " is not Fibonacci number.");
        }
        
	}
}

