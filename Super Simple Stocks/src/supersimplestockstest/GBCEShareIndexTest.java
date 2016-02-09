package supersimplestockstest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import supersimplestocks.GBCEShareIndex;
import supersimplestocks.Stock;
import supersimplestocks.StockException;
import supersimplestocks.StockStore;
import supersimplestocks.Trade.TradeType;

public class GBCEShareIndexTest {
	private static GBCEShareIndex gbceShareIndex = new GBCEShareIndex();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		// Record some trades for each the stocks on the share index
		String[] gcbeStockSymbols = gbceShareIndex.getStockSymbols();
		for (int i=0; i < gcbeStockSymbols.length; i++) {
			Stock stock = StockStore.getStock(gcbeStockSymbols[i]);
			stock.recordTrade(System.currentTimeMillis(), 100, TradeType.BUY, 24.0 + i);
			stock.recordTrade(System.currentTimeMillis(), 200, TradeType.SELL, 21.0 + i);
			stock.recordTrade(System.currentTimeMillis(), 400, TradeType.BUY, 25.0 + i);
			stock.recordTrade(System.currentTimeMillis(), 300, TradeType.SELL, 28.0 + i);
		}

	}
	@Test
	public void testGBCEShareIndex() {

		try {
			double shareIndex = gbceShareIndex.calculateAllShareIndex(false);
			assertTrue(shareIndex == 26.962901800753546);
					
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}
		
	@Test
	public void testGBCEShareIndexLog() {
		//gbceShareIndex = new GBCEShareIndex(true);
		try {
			double shareIndex = gbceShareIndex.calculateAllShareIndex(true);
			assertTrue(shareIndex == 26.962901800753542);
					
		} catch (StockException e) {
			fail(e.getMessage());
	}
}


}
