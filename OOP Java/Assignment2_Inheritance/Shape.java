package practise;

class Shape {

    public void display() {
        System.out.println("This is shape");
    }
}

class Rectangle1 extends Shape {

    public void displayRectangle1() {
        System.out.println("This is rectangular shape");
    }
}

class Circle extends Shape {

    public void displayCircle() {
        System.out.println("This is circular shape");
    }
}

class Square1 extends Rectangle1 {

    public void displaySquare1() {
        System.out.println("Square is a rectangle");
    }

    public static void main(String[] args) {

        Square1 s = new Square1();

        // Shape class method
        s.display();

        // Rectangle1 class method
        s.displayRectangle1();

        // Square1 class method
        s.displaySquare1();
    }
}