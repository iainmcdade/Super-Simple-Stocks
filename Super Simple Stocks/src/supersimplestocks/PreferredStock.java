package supersimplestocks;

public class PreferredStock extends Stock{

	public PreferredStock(String symbol, StockType type, int lastDividend, int fixedDividend, int parValue) {
		super(symbol, type, lastDividend, fixedDividend, parValue);
	}

	@Override
	public double getDividendYield(double tickerPrice) throws StockException{
		return Formula.getPreferredDividendYield(getFixedDividend(), getParValue(), tickerPrice);
	}

}
