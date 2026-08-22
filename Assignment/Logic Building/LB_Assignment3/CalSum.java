import java.util.Scanner;

class CalSum{
	static void calculateSum(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int N = sc.nextInt();
	int sum=0;
	
	for(int i = 1; i<=N; i++){
		sum=sum+i;
	
		}
		System.out.println("The sum of numbers from 1 to " + N + " is: " + sum);
	}
		public static void main(String args[]){
			
		calculateSum();
	
	}
} 