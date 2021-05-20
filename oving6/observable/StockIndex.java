package patterns.observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockIndex implements StockListener {
	private String ticker;
	private double index;
	private List<Stock> stocks;

	public StockIndex(String ticker, Stock... stocks) {
		this.stocks = new ArrayList<>();
		if (stocks != null) {
			Arrays.asList(stocks).stream().forEach(stock -> this.stocks.add(stock));
			Arrays.asList(stocks).stream().forEach(stock -> index += stock.getPrice());
			Arrays.asList(stocks).stream().forEach(stock -> stock.addStockListener(this)); //remember this one!!
		} else {
			index = 0.0;
		}
		this.ticker = ticker;
	}

	public void addStock(Stock stock) {
		if (!stocks.contains(stock)) {
			stocks.add(stock);
			index += stock.getPrice();
		}
	}

	public void removeStock(Stock stock) {
		if (stocks.contains(stock)) {
			stocks.remove(stock);
			index -= stock.getPrice();
		}
	}

	public double getIndex() {
		return index;
	}

	@Override
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
		if(stocks.contains(stock)) index += newValue - oldValue;

	}

}
