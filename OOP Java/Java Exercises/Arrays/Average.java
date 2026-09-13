package practise;


public class Average {

	public static void main(String[] args) {
		
		
		System.out.println("Enter the size of array ");
		int n= ConsoleInput.getInt();
		double avg=0;
		int sum=0;
		
		int arr[] = new int [n];
		System.out.println("Enter " + n + " Elements");
		
		for(int i=0; i<n; i++) {
         arr[i]=ConsoleInput.getInt();			
			
		}
		
		for(int i=0; i<n; i++) {
			sum+=arr[i];
			avg= sum/n;
		}
		System.out.println("The avag of the numbers is : "+sum);
		System.out.println("The avag of the numbers is : "+avg);
	}

}