package multicast.edu.umb.cs.cs680.hw08;

public class StockEvent{

	public String ticker;
	public float quote;

	public StockEvent(String ticker, float quote){
		this.quote=quote;
		this.ticker=ticker;
	}

	public String getTicker(){
		return this.ticker;
	}

	public float getQuote(){
		return this.quote;
	}

}
