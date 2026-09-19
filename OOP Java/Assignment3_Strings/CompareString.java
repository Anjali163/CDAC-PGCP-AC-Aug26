package in.cdac;

public class CompareString {

	
	public static void main(String[] args) {
	
	//2. Write a Java program to compare two strings lexicographically. Two strings 
			//are lexicographically equal if they are the same length and contain the same 
			//number of characters in the same positions.
			
			
			String str1 = "This is Exercise 1"; 
			String str2 = "This is Exercise 2";
			
			int result = str1.compareTo(str2);
			
			if (result == 0) {
	            System.out.println("The strings are lexicographically equal.");
	        } else if (result < 0) {
	            System.out.println("This is Exercise 1 less than  This is Exercise 2");
	        } else {
	            System.out.println("This is Exercise 1 greter than This is Exercise 2");
	        }
			
}
}