package supersimplestocks;

import java.util.ArrayList;

import supersimplestocks.Trade.TradeType;

public abstract class Stock {
	private String symbol;
	public enum StockType {COMMON, PREFERRED};
	private StockType type;
	private int lastDividend;
	private int fixedDividend;
	private int parValue;
	private ArrayList<Trade> trades = new ArrayList<Trade>();
	

	public Stock(String symbol, StockType type, int lastDividend, int fixedDividend, int parValue) {
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public abstract double getDividendYield(double tickerPrice) throws StockException;
	
	public double getPERatio(double tickerPrice) throws StockException {
		// Just use the lastDividend value for the PE Calculation
		// Should we use fixedDividend and parValue for preferred stocks?
		return Formula.getPERatio(tickerPrice, lastDividend);
	}
	
	public void recordTrade(long timestamp, int quantity, TradeType tradeType, double tradePrice) throws StockException {
		Trade trade = new Trade(timestamp, quantity, tradeType, tradePrice);
		trades.add(trade);
	}
	
	public double calculateStockPriceLast15Mins() throws StockException {
		long currentTime = System.currentTimeMillis();
		long startTime = currentTime - (15*60*1000);
		
		try {
			return calculateStockPrice(startTime, currentTime);
		}
		catch (StockException e) {
			throw new StockException(e.getMessage() + "No Trades in the last 15mins");
		}
	}
	
	// Calculate the stock price between two times specified in milliseconds
	private double calculateStockPrice(long startTime, long endTime) throws StockException {
		
		if (endTime <= startTime) {
			throw new StockException("End Time must be later than start time");
		}
		
		// Get all the trades that fall in the time window
		ArrayList<Trade> tradeList = new ArrayList<Trade>();
		for (Trade trade:trades) {
			long tradeTimestamp = trade.getTimestamp();
			if ((tradeTimestamp >= startTime) && (tradeTimestamp <= endTime)) {
				tradeList.add(trade);
			}
		}
		if (tradeList.isEmpty()) {
			throw new StockException("No trades in the time specified");
		}
		
		return Formula.getStockPrice(tradeList);
	}
		
	
	// Getters and Setters
	public int getLastDividend() {
		return lastDividend;
	}

	public int getFixedDividend() {
		return fixedDividend;
	}

	public int getParValue() {
		return parValue;
	}
	
}
