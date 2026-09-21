package com.anjali;

public class EquilateralTriangle implements RegularPolygon
{
	double sidelength;
	

	public EquilateralTriangle(double sidelength) {
		super();
		this.sidelength = sidelength;
	}

	@Override
	public int getNumSides() {
		
		return 3;
	}

	@Override
	public double getSideLength() {
		return sidelength;	
		
	}
}