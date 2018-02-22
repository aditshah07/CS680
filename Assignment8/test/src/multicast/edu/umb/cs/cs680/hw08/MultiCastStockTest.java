package multicast.edu.umb.cs.cs680.hw08;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;
import java.util.Random;
import java.util.Scanner;

public class MultiCastStockTest {

	StockQuoteObservable stock = new StockQuoteObservable();

	@Before
	public void createObserver() throws InterruptedException{

		TableObserver tableObserver = new TableObserver();
		PiechartObserver pieObserver = new PiechartObserver();
		ThreeDObserver threeDObserver = new ThreeDObserver();
		stock.addObserver(tableObserver);
		stock.addObserver(pieObserver);
		stock.addObserver(threeDObserver);
	}

	@Test
	public void displayStock() throws InterruptedException{

		Random r = new Random();
		for(int i=0; i<5; i++) {
			float quote = r.nextFloat()*1000;
			stock.changeQuote("Apple", quote);
            Thread.sleep(1000);   
            System.out.println("");
		}
	}	
	
}
