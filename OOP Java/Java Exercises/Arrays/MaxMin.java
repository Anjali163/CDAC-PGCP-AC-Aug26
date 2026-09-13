package practise;


public class MaxMin {

	public static void main(String[] args) {
	
		
		System.out.println("Enter the elemnts of array");
		int n= ConsoleInput.getInt();
		
		int arr[] = new int [n];
//		int copy[] = new int [n];
		
		
		System.out.print("Enter "+ n + " elemnets ");
		
		for(int i=0; i<n; i++) {

			arr[i]= ConsoleInput.getInt();
			
		}
		
		int maximum=arr[0];
		int minimum=arr[0];
		
		for(int i=0; i<n; i++) {
			
			if(arr[i]>maximum) {
				maximum= arr[i];	 
		     }
			
			if(arr[i]<minimum) {
				minimum= arr[i];
			}
			
//			System.out.println(arr[i]);
			
		}
	     
		System.out.println("Maximum is :"+maximum);
		 System.out.println("Minimum is: "+minimum);
		
		
		
	}
	

}