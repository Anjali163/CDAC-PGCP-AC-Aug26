package com.anjali;

import java.util.Arrays;
import java.util.Comparator;

public class SortingString {

	public static void main(String[] args) {
		String[] arr = { "B", "A", "C", "T", "E", "H", "D", "P" };

		Comparator<String> c = (a, b) -> a.compareTo(b);

		Arrays.sort(arr,c);
//		
		for (String a : arr) {
			System.out.println(a);
		}

	}

}
