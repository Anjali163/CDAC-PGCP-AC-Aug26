package practise;


public class StarPattern {

	public static void main(String[] args) {
		
	/*  4. Using For loops write a program to display the following pattern
		*
		**
		***
		****
		*****
*/
		
		System.out.println("Star Pattern: ");
		
		for(int i=1; i<=5; i++) { 
			
			for(int j=1; j<=i; j++) {
	
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}