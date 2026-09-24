package com.anjali;

interface Concat {
	String concat(String a, String b);
}

public class StringConcat {

	public static void main(String[] args) {
		Concat c = (x, y) -> {
			return x + y;
		};

		System.out.println(c.concat("Anjali", " Nanavare"));

	}

}