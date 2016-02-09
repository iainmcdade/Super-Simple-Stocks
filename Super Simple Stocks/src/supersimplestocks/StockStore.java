package supersimplestocks;

import java.util.HashMap;

import supersimplestocks.Stock.StockType;

public class StockStore {
	private static HashMap<String, Stock> stocks = new HashMap<String, Stock>();
	
	private static void createStockStore() throws StockException {

		stocks.put("TEA", (StockFactory.createStock("TEA", StockType.COMMON, 0, -1, 100)));
		
		stocks.put("POP", (StockFactory.createStock("POP", StockType.COMMON, 8, -1, 100)));
		
		stocks.put("ALE", (StockFactory.createStock("ALE", StockType.COMMON, 23, -1, 60)));
		
		stocks.put("GIN",(StockFactory.createStock("GIN", StockType.PREFERRED, 8, 2, 100)));
		
		stocks.put("JOE", (StockFactory.createStock("JOE", StockType.COMMON, 13, -1, 250)));
	}
	
	public static Stock getStock(String stockSymbol) throws StockException {
		if (stocks.isEmpty()) {
			createStockStore();
		}
		Stock stock = stocks.get(stockSymbol);
		if (stock == null) {
			throw new StockException("Store does not contain the stock: " + stockSymbol);
		}
		return stock;
	}
}

