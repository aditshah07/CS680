package multicast.edu.umb.cs.cs680.hw08;

import java.util.ArrayList;
import java.util.Observable;

public class StockQuoteObservable extends Observable {

	private ArrayList <StockEvent> stockEvents= new ArrayList<StockEvent>();

	public void changeQuote(String ticker, float quote) {
		this.stockEvents.add(new StockEvent(ticker, quote));
		this.setChanged();
		this.notifyObservers(new StockEvent(ticker, quote));
	}
}
