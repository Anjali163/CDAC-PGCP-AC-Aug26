package practise;


public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	System.out.println("Enter the day");
		date objdate = new date();
		System.out.println("Enter thd day");
		int day = ConsoleInput.getInt();
		
		System.out.println("ENter the month");
		int month = ConsoleInput.getInt();
		
		System.out.println("ENter the year");
		int year = ConsoleInput.getInt();
		
		System.out.println("ENter the number of days you want to add");
		int daysInMonth  = ConsoleInput.getInt();
		
		
		objdate.setDate(day, month, year);
		
//		System.out.println(objdate.getDay() + "/" + objdate.getMonth() + "/" + objdate.getYear());
		System.out.println("Original date: "
                + objdate.getDay() + "/"
                + objdate.getMonth() + "/"
                + objdate.getYear());

        objdate.addDays(days);

        System.out.println("New date: "
                + objdate.getDay() + "/"
                + objdate.getMonth() + "/"
                + objdate.getYear());
}
}