package practise;


public class NumberPattern1to6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/* Using for loops write a program to display the following 
		pattern
		1
		1 2 	
		1 2 3
		1 2 3 4
		1 2 3 4 5
		1 2 3 4 5 6

*/
		int num=0;
		System.out.println("---1 to 6 number pattern ---");
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j+" ");
			
			}
			System.out.println();
		}
		
	}

}