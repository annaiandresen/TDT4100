package patterns.observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stock {
	
	private double price;
	private String ticker;
	
	//Observeable
	private List<StockListener> listeners;
	
	public Stock (String ticker, double price) {
		if (price <= 0) throw new IllegalArgumentException();
		this.ticker = ticker;
		this.price = price;
		listeners = new ArrayList<>();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) throw new IllegalArgumentException();
		fireStockPriceChanged(this.price, price);
		this.price = price;
	}

	public String getTicker() {
		return ticker;
	}
	
	public void addStockListener(StockListener listener) {
		if (listeners.contains(listener)) throw new IllegalArgumentException();
		listeners.add(listener);
	}
	
	public void removeStockListener(StockListener listener) {
		if(!listeners.contains(listener)) throw new IllegalArgumentException();
		listeners.remove(listener);
	}
	
	public void fireStockPriceChanged(double oldValue, double newValue) {
		listeners.stream()
				.forEach(listener -> listener
				.stockPriceChanged(this, oldValue, newValue));
	}
	
	
}
