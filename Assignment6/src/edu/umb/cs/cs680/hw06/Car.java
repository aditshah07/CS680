package edu.umb.cs.cs680.hw06;

import java.util.ArrayList;
import java.util.Iterator;

public class Car {

	private float price;
	private int year;
	private String name;
	private float mileage;
	private ArrayList<Car> cars;
	private int count=0;

	public Car(String name, int year, float price, float mileage){

		this.name = name;
		this.year = year;
		this.price = price;	
		this.mileage = mileage;
	}

	public int getYear(){
		return this.year;
	}

	public float getMileage(){
		return this.mileage;
	}

	public float getPrice(){
		return this.price;
	}	

	public String getName(){
		return this.name;
	}

	public int getCount(){
		return this.count;
	}

	public void setCars(ArrayList<Car> cars){
		this.cars = cars;
	}

	public int getDominationCount(){
		int dominantcount=0;
		Iterator <Car> iterator = this.cars.iterator();
      	while(iterator.hasNext()){
      		Car nextCar = iterator.next();
			if((this.price>=nextCar.getPrice() && this.year<=nextCar.getYear() && this.mileage>=nextCar.getMileage()) && (this.price>nextCar.getPrice() || this.year<nextCar.getYear() || this.mileage>nextCar.getMileage()))
			{
				dominantcount++;
			}
      	}
      	this.count = dominantcount;
		return dominantcount;
	}

}