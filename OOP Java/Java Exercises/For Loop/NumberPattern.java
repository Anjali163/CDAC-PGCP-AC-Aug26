package practise;


public class NumberPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/* 6. Using for loops write a program to display the following pattern
		1
		2 3
		4 5 6
		7 8 9 10
	*/
	System.out.println("------Number pattern------------");
	int num=1;
	for(int i=1; i<=4;i++) {
		for(int j=1; j<=i; j++) {
		
			System.out.print(num +" ");
			num++;
			
		}
		System.out.println();
		
	}
	
	}

}