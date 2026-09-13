package practise;


public class CommonElements {

	public static void main(String[] args) {
		
		//10. Modify exercise 2 to accept 2 different values in 2 different arrays and  find the common elements between two array

	
		System.out.println("Enter the elements of 1st array");
	
		int a= ConsoleInput.getInt();
		
		System.out.println("Enter the elements of Second array");
		
		int b= ConsoleInput.getInt();
		
	int arr1[]= new int[a];
	int arr2[]= new int[b];
	
//	for 1st array
	System.out.println("Enter " + a + " elememts");
	for(int i=0; i<a; i++) {
		
		arr1[i]= ConsoleInput.getInt();
	}
	
	    System.out.println("Enter " + b + " elememts");
        for(int i=0; i<b; i++) {
		
		arr2[i]= ConsoleInput.getInt();
	}
	
        System.out.println("The common elements from the two array's ");
        
        for(int i=0; i<a; i++) {
        	for(int j=0; j<b; j++) {
        		
        		if(arr1[i]==arr2[j]) {
        			System.out.println(arr1[i]);
        		}
        	}
        	
        }
	
	
	}

}