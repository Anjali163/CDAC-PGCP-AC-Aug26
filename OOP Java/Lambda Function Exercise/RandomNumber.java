package com.anjali;

import java.util.Random;
import java.util.function.Supplier;

public class RandomNumber {

	public static void main(String[] args) {
		Random random = new Random();
		
		Supplier<Integer> c = () -> {
			return random.nextInt(900) + 100;
		};

		System.out.println(c.get());
	}

}