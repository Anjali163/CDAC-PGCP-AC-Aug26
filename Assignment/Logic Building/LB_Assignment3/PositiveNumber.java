import java.util.Scanner;

class PositiveNumber{
   static void askForPositiveNumber(){
   
   Scanner sc = new Scanner(System.in);
   int N;
   
   do{
		System.out.println("Enter a positive number: ");
		N = sc.nextInt();

	}
		while (N<=0);
		System.out.println("You entered a positive number: " + N);
		sc.close();
   
   }
		public static void main(String args[]){
			askForPositiveNumber();
	
   }



}