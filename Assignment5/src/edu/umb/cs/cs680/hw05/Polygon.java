package edu.umb.cs.cs680.hw05;
import java.awt.Point;
import java.util.ArrayList;


public class Polygon{
	
	private ArrayList <Point> points = new ArrayList <Point>();
	AreaCalculator areaCalc;

	public Polygon(ArrayList<Point> pointsAdd, AreaCalculator areaCalcNew){

		this.points = pointsAdd;
		this.areaCalc = areaCalcNew;
	}

	public void addPoint(Point point){
		this.points.add(point);
	}
	
	public void setAreaCalc(AreaCalculator areaCalcNew) {
		this.areaCalc = areaCalcNew;
	}
	
	public void removePoint(int pos) {
		points.remove(pos);
	}

	public ArrayList<Point> getPoints(){
		return this.points;
	}

	public float getArea() throws InsufficientPointsException{
		return areaCalc.getArea(this.getPoints());
	}
}