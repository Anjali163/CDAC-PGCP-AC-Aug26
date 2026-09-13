package practise;


public class ReverseArray {

	public static void main(String[] args) {
		//7.Modify exercise 2 Write a Java program to reverse an array of integer values
		
		System.out.println("Enter the size of array ");
		int n= ConsoleInput.getInt();
		
	
		
		int arr[] = new int [n];
		System.out.println("Enter " + n + " Elements");
		
		for(int i=0; i<n; i++) {
         arr[i]=ConsoleInput.getInt();			
			
		}
		// To reverse array
		for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
	}

}