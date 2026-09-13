package practise;


public class every7thnumber {

	public static void main(String[] args) {
		
		//3. using for loops write a Java Program to display every 7th number from 1 to 200
		// to display every 7th number logic is 
		
		int n=200;
		System.out.println("The number between 1 to 200 at every 7th position is: ");
		for(int i=1; i<=n; i++) {
			
			if(i%7==0)
				System.out.println(i);
		}
	}
	
}