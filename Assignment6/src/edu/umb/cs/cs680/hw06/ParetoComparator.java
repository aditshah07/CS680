package edu.umb.cs.cs680.hw06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ParetoComparator implements Comparator<Car>{
	
	public ParetoComparator(ArrayList<Car> cars) {	
		Iterator <Car> iterator = cars.iterator();
      	while(iterator.hasNext()){
      		iterator.next().setCars(cars);
      	}
	}

	public int compare(Car car1, Car car2){
		return car1.getDominationCount()-car2.getDominationCount();
	} 


}