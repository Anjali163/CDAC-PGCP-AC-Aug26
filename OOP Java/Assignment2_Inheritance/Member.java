package practise;

public class Member {
	
	private String name;
	private int age;
	private String phoneNo;
	private String address;
	private double salary;
	
	void printSalary(double salary){
		System.out.println(this.salary);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Age  : " + age);
		System.out.println("phone number : " + phoneNo);
		System.out.println("Address : " + address);
		
	}
	
	public static void main(String[] args) {
		
		ConsoleInput input = new ConsoleInput();
		
		// for Member class
		
		Member m = new Member();
		
		PrimeMembers pm = new PrimeMembers();
		    
	      System.out.print("Enter your name: ");
	        String name = input.getstring();
	        
	     System.out.print("Enter Age: ");
	        int age = input.getInt();
	        
	     System.out.print("Enter Phone no.: ");
	     	String phoneNo = input.getstring();
	        
	     System.out.print("Enter Address: ");
	     	String address = input.getstring();
	     	
	     System.out.print("Enter salary: ");
	     	double salary = input.getDouble();
        
	        pm.setName(name);
	        pm.setAge(age);
	        pm.setPhoneNo(phoneNo);
	        pm.setAddress(address);
	        pm.setSalary(salary);
	        	       
	        //m.display();  
	        //m.printSalary(salary);
	        
	        //for PrimeMember class
	        	        
	        System.out.println("Enter JoiningYear: ");
	        int year = input.getInt();
	        
	        System.out.println("Enter JoiningFees: ");
	        int fees = input.getInt();
	        
	        System.out.println("Enter isActive: ");
	        String active = input.getstring();
	        
	        
	        pm.setYear(year);
	        pm.setFees(fees);
	        pm.setActive(active);
	        
	        pm.display();
	        
	        
	}

}
