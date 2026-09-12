package practise;

public class Employee {
	
	String name;
	int year;
	String address;
	
	Employee(String n, int y, String ad){
		name = n;
		year = y;
		address = ad;

	}
	
	void display() {
		System.out.println(name + "\t\t" + year + "\t\t" + address );
	}
	public static void main(String[] args) {
		
		Employee emp1 = new Employee("Robert", 1994, "64C-WallsStreet");
		Employee emp2 = new Employee("Sam", 2000, "68D-WallsStreet");
		Employee emp3 = new Employee("John", 1999, "26B-WallsStreet");
			
		System.out.println("Name\t\tYear of joining\t\taddress");	
		emp1.display();
		emp2.display();
		emp3.display();
		
		
		
	}

}


