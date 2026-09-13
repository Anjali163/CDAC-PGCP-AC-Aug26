package practise;

public class Rectangle {
	double length;
	double breadth;
	
	public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
	public void printArea() {
        System.out.println("Area = " + (length * breadth));
    }
	
	public void printPerimeter() {
        System.out.println("Perimeter = " + (2 * (length + breadth)));
    }
	
	
	public static void main(String[] args) {
		

        // Rectangle object
        Rectangle r = new Rectangle(10, 5);

        System.out.println("----- Rectangle -----");
        r.printArea();
        r.printPerimeter();


        // Square object
        Square s = new Square(5);

        System.out.println("\n----- Square -----");
        s.printArea();
        s.printPerimeter();
    }

}




























