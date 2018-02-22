package observable.edu.umb.cs.cs680.hw08;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {
	private StockEvent arg;

	public void update(Observable o, Object arg) {
		this.arg = (StockEvent) arg;
		System.out.println("TableObserver ticker: " + this.arg.getTicker() + " Quote: " + this.arg.getQuote());	
	}
}
