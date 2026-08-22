import java.util.Scanner;

class MultiplicationTable{
     static void printMultiplicationTable(){
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the number: ");
	  int number = sc.nextInt();
	 
	  
	 for(int i = 1; i<=10; i++){
		 
		System.out.println(number + " x " + i + " = " + number*i);
		 
	 }
	 }
	  public static void main(String args[]){
	  
	  printMultiplicationTable();
	  }
}