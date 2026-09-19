package in.cdac;
import java.util.regex.Pattern;

public class ReplaceSubstring {

	public static void main(String[] args) {
		
		String str = "The quick brown fox jumps over the lazy dog.";
		System.out.println("Original string: " + str);
		String regex = "fox";
		String replacement = "cat";
		
		Pattern.compile(regex);
		
		String newstr = str.replaceAll(regex, replacement);
		
		System.out.println("New String: "+ newstr);
		
	}

}
