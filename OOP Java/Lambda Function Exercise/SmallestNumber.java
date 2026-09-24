package com.anjali;

import java.util.function.BiPredicate;

public class SmallestNumber {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> b = (x, y) -> x < y;
		
		int arr[] = { 9, 8, 7, 5, 4, 3, 2, 6, 1, 1, 600 };
		int min = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			
			if (b.test(arr[i], min)) {
				min = arr[i];
			}
			
		}

		System.out.println(min);
	}

}