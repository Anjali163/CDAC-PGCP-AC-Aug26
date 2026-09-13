package practise;

public class evennumbers {

	public static void main(String[] args) {
		
        //2. using for loops write a Java Program to display all even numbers from 1 to 500
		
		int n=500;
		System.out.println("The even numbers between 1 to 500 are: ");
		
		for(int i=0;i<=n; i++) {
			if(i%2==0)
				System.out.println(i);
			
		}
		
	}

}