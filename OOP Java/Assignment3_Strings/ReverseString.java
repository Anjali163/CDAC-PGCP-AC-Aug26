package in.cdac;

public class ReverseString {

	public static void main(String[] args) {
		
		String org = "The quick brown fox jumps";
		
		String reverseString = new StringBuilder(org).reverse().toString();
		
		System.out.println("The given string is: " + org);
		System.out.println("The string in reverse order is: " + reverseString);
	}

}
