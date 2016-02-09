package supersimplestocks;

import java.util.ArrayList;

public abstract class ShareIndex {

	private String shareIndexName;
	private String[] stockSymbols;
	
	ShareIndex(String shareIndexName, String[] stockSymbols) {
		this.shareIndexName = shareIndexName;
		this.stockSymbols = stockSymbols;
	}
	
	public double calculateAllShareIndex(boolean calculateWithLogFormula) throws StockException {
		// Get the stocks from the stock symbols
		double[] stockPrices = new double[stockSymbols.length];

		for (int i=0; i<stockSymbols.length; i++) {
			Stock stock = StockStore.getStock(stockSymbols[i]);
			
			// Assume that the price of the stock is based on the last 15 mins trades
			double stockPrice = stock.calculateStockPriceLast15Mins();
			stockPrices[i] = stockPrice;
		}
		
		if (calculateWithLogFormula) {
			return Formula.getGeometicMeanLog(stockPrices);
		}
		else {
			return Formula.getGeometicMean(stockPrices);
		}
	}
	
	public String[] getStockSymbols() {
		return stockSymbols;
	}
}
