package edu.umb.cs.cs680.hw06;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CarTest {

    ArrayList<Car> cars = new ArrayList<Car>();

    @Before
    public void createCars(){

        cars.add(new Car("Audi",2011,18000f,30000f));
        cars.add(new Car("Honda",2013,9000f,14000f));
        cars.add(new Car("Toyota",2015,9000f,8000f));
        cars.add(new Car("Ford",2015,9000f,5000f));
        cars.add(new Car("Subaru",2016,6000f,10000f));
    }

    @Test
    public void yearComparatorTest(){
        Collections.sort(cars, new YearComparator());
        assertThat((cars.get(0)).getName(),is("Audi"));
    }

    @Test
    public void priceComparatorTest(){
        Collections.sort(cars, new PriceComparator());
        assertThat((cars.get(0)).getName(),is("Audi"));
    }

    @Test
    public void mileageComparatorTest(){
        Collections.sort(cars, new MileageComparator());
        assertThat((cars.get(0)).getName(),is("Audi"));
    }

    @Test
    public void printYearComparatorTest(){
        Collections.sort(cars, new YearComparator());
        System.out.println("Output for YearComparator");
        System.out.println("Car \t Year");
        Iterator <Car> iterator = this.cars.iterator();
        while(iterator.hasNext()){
            Car nextCar = iterator.next();
            System.out.println(nextCar.getName() + "\t" + nextCar.getYear());
        }
        System.out.println("");
    }

    @Test
    public void printPriceComparatorTest(){
        Collections.sort(cars, new PriceComparator());
        System.out.println("Output for PriceComparator");
        System.out.println("Car \t Price");
        Iterator <Car> iterator = this.cars.iterator();
        while(iterator.hasNext()){
            Car nextCar = iterator.next();
            System.out.println(nextCar.getName() + "\t" + nextCar.getPrice());
        }
        System.out.println("");

    }

    @Test
    public void printMileageComparatorTest(){
        Collections.sort(cars, new MileageComparator());
        System.out.println("Output for MileageComparator");
        System.out.println("Car \t Mileage");
        Iterator <Car> iterator = this.cars.iterator();
        while(iterator.hasNext()){
            Car nextCar = iterator.next();
            System.out.println(nextCar.getName() + "\t" + nextCar.getMileage());
        }
        System.out.println("");
    }

     @Test
    public void PeratoComparatorTest(){
        Collections.sort(cars, new ParetoComparator(cars));
        System.out.println("Output for ParetoComparator");
        System.out.println("Car \t Year \t Price \t Mileage   DominantCount");
        Iterator <Car> iterator = this.cars.iterator();
        while(iterator.hasNext()){
            Car nextCar = iterator.next();
            System.out.println(nextCar.getName() + "\t" + nextCar.getYear() + "\t" + nextCar.getPrice() + "\t" + nextCar.getMileage() + "\t\t" + nextCar.getCount());
        }
        System.out.println("");        
    }

}