package edu.umb.cs.cs680.hw05;
import java.awt.Point;
import java.util.ArrayList;

public class TriangleAreaCalc implements AreaCalculator{

	public float getArea(ArrayList<Point> points) throws InsufficientPointsException{
		float area = 0.0f;
		if(points.size() == 3) {
			float ab = (float)points.get(0).distance(points.get(1));
			float bc = (float)points.get(1).distance(points.get(2));
			area = (float)0.5 * ab * bc;
		}else throw new InsufficientPointsException("Insufficient/More Points");
		//System.out.println("area of triangle" + area);
		return area;
	}
}