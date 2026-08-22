import java.util.Scanner;

class AgeChecker{
	
	static void AgeCheckerCat(int Age){
	String result = (Age<18)? "minor" : (Age<18)? "Adult" : "Senior citizen";	
		
		System.out.println(result);
	
	}
		public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the age: ");
		int Age = sc.nextInt();
	
		AgeCheckerCat(Age);
		
		}
	}
