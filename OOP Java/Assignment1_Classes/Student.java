package practise;

public class Student {
	String name ;
	int roll_no;
	String phone_no;
	String address;
	
void display() {
		
		System.out.println("Name     : " + name);
		System.out.println("roll_no  : " + roll_no);
		System.out.println("phone_no : " + phone_no);
		System.out.println("address  : " + address);
	}
	

	public static void main(String[] args) {
		
		Student s1 = new Student();
		
			s1.roll_no = 2;
			s1.name = "John";
			System.out.println("------Part a------");
			System.out.println("Name    : " + s1.name);
			System.out.println("roll_no : " + s1.roll_no);
			System.out.println();
		
		Student s2 = new Student();
		
			s2.name = "Sam";
			s2.roll_no = 3;
			s2.phone_no = "9867546567";
			s2.address = "Pune";
				
		
		Student s3 = new Student();
		
			s3.name = "John";
			s3.roll_no = 2;
			s3.phone_no = "98689769076";
			s3.address = "Solapur";
			
			
			System.out.println("------Part b------");
			s2.display();
			System.out.println();
			s3.display();
		
	}
}

