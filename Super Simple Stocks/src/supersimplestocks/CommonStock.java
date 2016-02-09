package supersimplestocks;

public class CommonStock extends Stock{

	public CommonStock(String symbol, StockType type, int lastDividend, int fixedDividend, int parValue) {
		super(symbol, type, lastDividend, fixedDividend, parValue);
	}

	@Override
	public double getDividendYield(double tickerPrice) throws StockException{
		return Formula.getCommonDividendYield(getLastDividend(), tickerPrice);
	}

}
