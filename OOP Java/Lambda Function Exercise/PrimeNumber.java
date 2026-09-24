package com.anjali;

import java.util.function.Function;
import java.util.function.Predicate;

public class PrimeNumber {

	public static void main(String[] args) {

		Predicate<Integer> p = (x) -> {
			int num = 1;
			for (int i = 1; i <= x / 2; i++) {
				if (x % i == 0) {
					num++;
				}
			}

			if (num != 2) {
				return true;
			} else {
				return false;
			}
		};
		int x = 5;
		System.out.println(p.test(x) ? (x + " Not a prime") : (x + " Prime"));

	}

}