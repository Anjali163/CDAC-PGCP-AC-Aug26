package com.anjali;

public class Square implements RegularPolygon {
	
	double side;
	
	public Square(double side) {
		super();
		this.side = side;
	}

	@Override
	public int getNumSides() {
		
		return 4;
	}

	@Override
	public double getSideLength() {
		
		return side;
	}

}
