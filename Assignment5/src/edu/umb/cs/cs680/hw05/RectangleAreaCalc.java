package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalc implements AreaCalculator{

	public float getArea(ArrayList<Point> points) throws InsufficientPointsException{
		float area = 0.0f;
		if(points.size() == 4) {
			float ab = (float)points.get(0).distance(points.get(1));
			float ad = (float)points.get(0).distance(points.get(3));
			area = (float) ab * ad;
		}else throw new InsufficientPointsException("Insufficient/More Points");
		//System.out.println("area of rectangle" + area);
		return area;
	}
}