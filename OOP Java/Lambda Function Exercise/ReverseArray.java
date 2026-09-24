package com.anjali;

import java.util.function.Function;

public class ReverseArray {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		Function<int[], int[]> a = (arr1) -> {
			int result[] = new int[arr1.length];

			for (int i = 0; i < arr.length; i++) {
				result[arr.length - 1 - i] = arr1[i];
			}
			
			return result;
		};

		int[] reversed = a.apply(arr);
		
		for(int i : reversed) {
			System.out.println(i);
		}
	}

}