package com.anjali;

import java.util.function.BiPredicate;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,4,5,6,7,8,9};
		
		BiPredicate<Integer,Integer> b = (x,y) -> x>y;
		int max = arr[0];
		for(int i = 0;i<arr.length ; i++) {
			if(b.test(arr[i], max)) {
				max = arr[i];
			}
		}
		
		System.out.println(max);
	}

}