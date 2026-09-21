package com.anjali;

public class Main {

	public static void main(String[] args) {
		EquilateralTriangle triangle = new EquilateralTriangle(7);
		System.out.println("EquilateralTriangle");
		System.out.println("Number of sides: " + triangle.getNumSides());
		 System.out.println("Side length: " + triangle.getSideLength());
		 
		 Square sq = new Square(8);
		 System.out.println("=============================================");
		 System.out.println("Square");
		 System.out.println("Number of sides: " + sq.getNumSides());
		 System.out.println("Side length: " + sq.getSideLength());
		 
		 RegularPolygon[] polygons = {triangle, sq};
		 
		int total = RegularPolygon.totalSides(polygons);
		
		 System.out.println("Total number of sides: " + total);
		 
		 System.out.println(triangle.getPerimeter());
		 System.out.println(sq.getPerimeter());
		 
		 System.out.println(triangle.getInteriorAngle());
		 System.out.println(sq.getInteriorAngle());

	}

}
