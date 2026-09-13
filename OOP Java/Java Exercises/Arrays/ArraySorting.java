package practise;


public class ArraySorting {

	public static void main(String[] args) {
		
		System.out.println("Enter the size of array: ");
        int n= ConsoleInput.getInt();

        int [] arr= new int [n];
        System.out.println("enter " + n + " elements");
        
        for(int i=0; i<n; i++) {
        	arr[i]= ConsoleInput.getInt();
        	
        }
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Display sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
		
		
	}

}