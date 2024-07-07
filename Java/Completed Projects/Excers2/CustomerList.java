class CustomerList {
	
	private Customer [] myList = new Customer[50];

	private int length = 0;
	
		
	void InsertCustomer(Customer newCustomer){

		myList[length] = newCustomer;
		length++;
		System.out.println("Customer inserted successfully.");
		
	}
	
	
	void LookupCustomer(String RN) {
		
		for (int i = 0; i < length; i++) {
			if (myList[i].getCode().equals(RN)) {
				System.out.println("Name: " + myList[i].getName() + " Code: " + myList[i].getCode() + " Registration date: " + myList[i].getDate());
				break;
			}else{
				System.out.println("Customer not found");
			}
		}	
	}
	
	
	void DisplayList() {
		if (length == 0) {
			System.out.println("Customer list is empty.");
			
		}else{
				System.out.println("Customer List:");
				for (int i = 0; i < length; i++) {
					System.out.println("Name: " + myList[i].getName() + " Code: " + myList[i].getCode() +  " Registration date: " + myList[i].getDate());
				}	
			}
		
	}
	
}