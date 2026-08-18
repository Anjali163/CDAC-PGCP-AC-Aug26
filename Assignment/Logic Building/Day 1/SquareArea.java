import java.util.Scanner;

class SquareArea{
	public static void main(String args[]){

	System.out.println("Enter the side");
	Scanner sc = new Scanner(System.in);

	int side = sc.nextInt();
	int Area = side*side;

	System.out.println(Area);
	}
}