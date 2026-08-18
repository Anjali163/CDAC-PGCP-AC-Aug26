import java.util.Scanner;

class RectangleArea{
	public static void main(String args[]){

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the length");
		int length = sc.nextInt();
	System.out.println("Enter the width");
		int width = sc.nextInt();

	int Area = length*width;

	System.out.println(Area);

	}
}