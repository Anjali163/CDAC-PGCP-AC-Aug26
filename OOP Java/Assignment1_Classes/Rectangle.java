package practise;

public class Rectangle {
	
	int length ;
	int breadth;
	
	int area() {		
		return length*breadth;
	}
	
	Rectangle(int l , int b){
		
		length = l;
		breadth = b;	
	}

	public static void main(String[] args) {
		
		Rectangle R1 = new Rectangle(4,5);
		Rectangle R2 = new Rectangle(5,8);
		
		System.out.println("Area of 1st rectangle = " + R1.area());
		System.out.println("Area of 2nd rectangle = " + R2.area());
	}

}
