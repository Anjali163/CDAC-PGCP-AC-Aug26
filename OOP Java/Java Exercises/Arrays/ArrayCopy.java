package practise;


public class ArrayCopy {

	public static void main(String[] args) {
	//.Modify exercise 2 Write a Java program to copy an array by itera ng the array
		
		System.out.println("Enter the elemnts of array");
		int n= ConsoleInput.getInt();
		
		int arr[] = new int [n];
		int copy[] = new int [n];
		System.out.print("Enter "+ n + " elemnets ");
		
		for(int i=0; i<n; i++) {

			arr[i]= ConsoleInput.getInt();
			
		}
		
		for(int i=0; i<n; i++) {
			
			copy[i]=arr[i] ;
		}
		
		System.out.println("Original array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

       
        System.out.println("\nCopied array:");

        for (int i = 0; i < n; i++) {
            System.out.print(copy[i] + " ");
        }
		
	}

}