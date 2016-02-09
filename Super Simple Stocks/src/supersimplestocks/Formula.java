package supersimplestocks;

import java.util.ArrayList;

public class Formula {

	public static double getCommonDividendYield(int lastDividend, double tickerPrice) throws StockException {
		if (tickerPrice == 0) {
			throw new StockException("GetCommonDividend: Ticker Price cannot be zero");
		}
		return lastDividend/tickerPrice;
	}
	
	// fixedDividend is a percentage
	public static double getPreferredDividendYield(int fixedDividend, int parValue, double tickerPrice) throws StockException {
		if (tickerPrice == 0) {
			throw new StockException("GetPreferredDivident: Ticker Price cannot be zero");
		}		
		return ((fixedDividend/(double)100) * parValue)/tickerPrice;
	}
	
	public static double getPERatio(double tickerPrice, int dividend) throws StockException {
		if (dividend == 0) {
			throw new StockException("GetPERation: Dividend cannot be zero");
		}
		return tickerPrice/dividend;
	}
	
	public static double getGeometicMean(double[] stockPrices) throws StockException {
		double numberStockPrices = stockPrices.length;
		if (numberStockPrices == 0) {
			throw new StockException("GetGeometricMean: No Stock Prices");
		}
		double productStockPrices = 1.0d;
		for (int i=0; i<numberStockPrices; i++) {
			// If any stock price is zero then the result will always be zero
			if (stockPrices[i] == 0) {
				return 0.0d;
			}
			productStockPrices=productStockPrices*stockPrices[i];			
		}
		double geoMean = Math.pow(productStockPrices, 1.0/numberStockPrices);
		
		return geoMean;
	}
	
	public static double getGeometicMeanLog(double[] stockPrices) throws StockException {
		double numberStockPrices = stockPrices.length;
		if (numberStockPrices == 0) {
			throw new StockException("GetGeometricMeanLog: No Stock Prices");
		}
		double logStockPrices = 0.0d;
		for (int i=0; i<numberStockPrices; i++) {
			// If any stock price is zero then the result will always be zero
			if (stockPrices[i] == 0) {
				return 0.0d;
			}
			logStockPrices+= Math.log(stockPrices[i]);
		}
		double geoMean = Math.exp(logStockPrices / numberStockPrices);
		
		return geoMean;
	}
	
	public static double getStockPrice(ArrayList<Trade> trades) throws StockException {
		
		if (trades.isEmpty()) {
			throw new StockException("GetStockPrice: No Trades in the list");
		}
		
		double sumTradePriceQuantity = 0.0d;
		int sumQuantity = 0;
		
		for (Trade trade:trades) {
			sumTradePriceQuantity += (trade.getTradePrice() * trade.getQuantityOfShares());
			sumQuantity += trade.getQuantityOfShares();
		}
		
		return sumTradePriceQuantity / sumQuantity;
	}
}
