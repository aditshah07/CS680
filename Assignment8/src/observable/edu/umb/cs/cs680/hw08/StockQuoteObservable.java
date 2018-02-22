package observable.edu.umb.cs.cs680.hw08;

import java.util.Observable;

public class StockQuoteObservable extends Observable {

	private StockEvent stockEvent;

	public void changeQuote(String ticker, float quote) {
		this.stockEvent = new StockEvent(ticker, quote);
		this.setChanged();
		this.notifyObservers(this.stockEvent);
	}

}
