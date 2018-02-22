package edu.umb.cs.cs680.hw05;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;
import java.awt.Point;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

public class RectangleAreaCalcTest {

	private Polygon p;
  private Polygon p2;
	ArrayList<Point> al = new ArrayList<Point>();
  ArrayList<Point> al2 = new ArrayList<Point>();
  ArrayList<Polygon> polygons = new ArrayList<Polygon>();

  	@Before
  	public void createRectangle(){
      al.add( new Point(0,10) ); 
      al.add( new Point(0,0) ); 
      al.add( new Point(10,0) ); 
      al.add( new Point(10,10) );
      p = new Polygon( al, new RectangleAreaCalc());
      polygons.add(p);
      al2.add( new Point(0,5) ); 
      al2.add( new Point(0,0) ); 
      al2.add( new Point(5,0) ); 
      al2.add( new Point(5,5) );
      p2 = new Polygon( al2, new RectangleAreaCalc());
      polygons.add(p2);
  	}
  	
  	@Test (expected = InsufficientPointsException.class)
  	public void exceptionForRectangle() throws InsufficientPointsException{
      polygons.get(0).setAreaCalc( new TriangleAreaCalc() );
      polygons.get(0).getArea();
  	}

  	@Test
  	public void checkAreaOfRectangle1() throws InsufficientPointsException{
      float actual = polygons.get(0).getArea(); // rectangle’s area
      float expected = 100.0f;
      assertThat(actual,is(expected));
  	}

    @Test
    public void checkAreaOfRectangle2() throws InsufficientPointsException{
      float actual = polygons.get(1).getArea(); // rectangle’s area
      float expected = 25.0f;
      assertThat(actual,is(expected));
    }

    @Test
    public void connvertRectangleToTriangle() throws InsufficientPointsException{
      polygons.get(0).removePoint(3);
      polygons.get(0).setAreaCalc( new TriangleAreaCalc());
      float actual = polygons.get(0).getArea(); // triangle’s area
      float expected = 50.0f;
      assertThat(actual,is(expected));
    } 

  	@Test
  	public void convertTriangleToRectangle() throws InsufficientPointsException{
  	  polygons.get(0).removePoint(3);
      polygons.get(0).addPoint( new Point(10,10) );
      polygons.get(0).setAreaCalc( new RectangleAreaCalc() );
      float actual = p.getArea(); // rectangle’s area
      float expected = 100.0f;
      assertThat(actual,is(expected));
  	}

    @Test
    public void printRectangle() throws InsufficientPointsException{
      Iterator <Polygon> iterator = polygons.iterator();
      while(iterator.hasNext()){
        System.out.println("area of rectangle: " + iterator.next().getArea());
        System.out.flush();
      }
    }

}