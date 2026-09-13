package practise;


public class PrintDuplicate {

	public static void main(String[] args) {
		
		// 8.Modify exercise 2 Write a Java program to find the duplicate values of an array of integer values

		System.out.println("Enter the size of array ");
		int n= ConsoleInput.getInt();
		
	
		
		int arr[] = new int [n];
		System.out.println("Enter " + n + " Elements");
		
		for(int i=0; i<n; i++) {
         arr[i]=ConsoleInput.getInt();			
			
		}
		 System.out.println("Duplicate values:");
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				 
				  if (arr[i] == arr[j]) {
	                    System.out.println(arr[i]);
			}
		}

	}

}
}