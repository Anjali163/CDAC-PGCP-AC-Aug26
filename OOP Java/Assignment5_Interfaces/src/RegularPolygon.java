package com.anjali;

public interface RegularPolygon {
	
	int getNumSides() ;
	double  getSideLength();	
	
	 static int totalSides(RegularPolygon[] polygons){
		int total = 0;
		
		for (RegularPolygon polygon : polygons) {
			total = total + polygon.getNumSides() ;
		}
		
		return total;
	}
	 
	public default double getPerimeter() {
		double perimeter = getNumSides()*getSideLength();	
		return perimeter;
	}
	  
	default double getInteriorAngle() {
		//double pi = 3.14;
		 int n = getNumSides();
		return (n-2)*Math.PI/n;
	}


}
	

