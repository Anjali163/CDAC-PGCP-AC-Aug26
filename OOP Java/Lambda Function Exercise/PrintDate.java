package com.anjali;

import java.util.Date;
import java.util.function.Supplier;

public class PrintDate {
	
	public static void main(String[] args) {
		Supplier<String> s = () ->{
			
			Date d = new Date();
			return d.toString();
		};
		
		System.out.println( s.get());
	}
	
	

}