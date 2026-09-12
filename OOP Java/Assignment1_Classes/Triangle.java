package practise;

public class Triangle {
	
	double side1;
	double side2;
	double side3;
	
	
	 Triangle(double s1, double s2, double s3){
		 
		 side1 = s1;
		 side2 = s2;
		 side3 = s3;
		 
		 
	 }
	 
	 double perimeter() {
		 
		 return side1 + side2 +side3;
		 
		 }
		 
double area() {
		 
		 return (side1*side2)/2;
		 
		 }

	public static void main(String[] args) {
		
		Triangle t = new Triangle(3, 4, 5);
		
		System.out.println("Perimeter = " + t.perimeter());
		
		System.out.println("Area = " + t.area());
	}

}
