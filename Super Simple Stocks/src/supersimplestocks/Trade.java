package supersimplestocks;

public class Trade {

	private long timestamp;
	private int quantityOfShares;
	public enum TradeType {BUY, SELL};
	private TradeType tradeType;
	private double tradePrice;
	
	public Trade(long timestamp, int quantityOfShares, TradeType tradeType, double tradePrice) {
		this.timestamp = timestamp;
		this.quantityOfShares = quantityOfShares;
		this.tradeType = tradeType;
		this.tradePrice = tradePrice;
	}
	
	public double getTradePrice() {
		return tradePrice;
	}
	
	public int getQuantityOfShares() {
		return quantityOfShares;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
}
