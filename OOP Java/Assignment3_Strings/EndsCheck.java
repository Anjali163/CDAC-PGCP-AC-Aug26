package in.cdac;

public class EndsCheck {

	public static void main(String[] args) {
		
		
		String str1= "Python Exercises" ;
		String str2 = "Python Exercise";
		
		String suffix = "se";
		
		boolean result1= str1.endsWith(suffix);
		boolean result2 = str2.endsWith(suffix);
		
		System.out.println(str1 + " Ends with " + suffix + " ? " + result1);
		System.out.println(str2 + " Ends with " + suffix + " ? " + result2);
	
		

	}

}