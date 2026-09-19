package in.cdac;

public class CharAtIndex {
	
public static void main(String[] args) {
		
		//1. Write a Java program to get the character at the given index within the String.  
		
		String str = "Java Exercises!";
		
		System.out.println("Original String = " + str);
		int index1=0;
		int index2=10;
		
		if (index1 >= 0 && index1 < str.length()) {
		
		System.out.println("The character at position " + index1 +" is " +  str.charAt(index1));
		}else
			System.out.println("The character at position 0 is out of scope" );
		
		if (index2 >= 0 && index1 < str.length()) {
			
			System.out.println("The character at position " + index2 + " is " + str.charAt(index2));
			}else
				System.out.println("The character at position 10 is out of scope" );	
}
}
