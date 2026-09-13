package practise;

public class AddArrays {
	
public static void main(String[] args) {
		
		
		System.out.println("Enter the elements of array: ");
		
		int n= ConsoleInput.getInt();
		int sum= 0;
		int [] arr = new int [n];
		System.out.println("Enter " + n +  " elements ");
		
		for(int i=0; i<n; i++) {
			arr[i]= ConsoleInput.getInt();
		}

		for(int i=0; i<n; i++) {
//			System.out.println("The elements are: " +arr[i]);
			System.out.println(arr[i]);
			sum+=arr[i];
		}
		
		System.out.println("The sum of all elements of array is :" +sum);
	}

}


