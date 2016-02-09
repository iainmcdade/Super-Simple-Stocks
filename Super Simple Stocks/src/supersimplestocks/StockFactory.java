package supersimplestocks;

import supersimplestocks.Stock.StockType;

public class StockFactory {

	public static Stock createStock(String stockSymbol, StockType stockType, int lastDividend, int fixedDividend, int parValue) throws StockException {
		switch (stockType) {
			case COMMON: {
				return new CommonStock(stockSymbol, stockType, lastDividend, fixedDividend, parValue);			
			}
			case PREFERRED: {
				return new PreferredStock(stockSymbol, stockType, lastDividend, fixedDividend, parValue);			
			}
			default: {
				throw new StockException("Stock Type is incorrect");
			}
		}
	}
}
