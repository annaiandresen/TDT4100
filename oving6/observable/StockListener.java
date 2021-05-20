package patterns.observable;

public interface StockListener {
	
	/**
	 * Observer method to keep observers updated. 
	 * @param stock
	 * @param oldValue
	 * @param newValue
	 */
	void stockPriceChanged(Stock stock, double oldValue, double newValue);

}
