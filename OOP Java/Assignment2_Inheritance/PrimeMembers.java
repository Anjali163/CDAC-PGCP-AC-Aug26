package practise;

public class PrimeMembers extends Member {
	
	private int year;
	private int fees;
	private String active;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


	public double getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}


	public String isActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}



	@Override
	public void display() {
		
		super.display();
		System.out.println("JoiningYear: " + year);
		System.out.println("JoiningFees: " + fees);
		System.out.println("isActive?: " + active);
		
	}
	
	
	
	
	
	
	


}
