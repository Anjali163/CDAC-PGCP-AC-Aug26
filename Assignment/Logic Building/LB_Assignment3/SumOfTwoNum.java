import java.util.Scanner;

class SumOfTwoNum{
	static int SumOfNum(int num1, int num2){
	return num1+num2;
	}
		public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the 1st number: ");
		int num1 = sc.nextInt();
		
		System.out.println("Enter the 2nd number: ");
		int num2 = sc.nextInt();
		
		int sum = SumOfNum(num1, num2);
		
		System.out.println(sum);
		
		
		
		
		
		}
	}
