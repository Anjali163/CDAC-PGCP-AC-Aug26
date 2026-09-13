package practise;

public class Parent {
	
	void display() {
		System.out.print("This is parent class");
	}
	
	
	public class Child extends Parent {
		
		void show() {
			System.out.print("This is Child class");
		}

	}

	public static void main(String[] args) {
		Parent objP = new Parent();
		Child objC =new Child();
		
		objP.display();
		System.out.println();
		objC.show();
		System.out.println();
		objC.display();
		

	}

}
