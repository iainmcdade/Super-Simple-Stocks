package supersimplestockstest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import supersimplestocks.CommonStock;
import supersimplestocks.Stock.StockType;
import supersimplestocks.StockException;
import supersimplestocks.Trade.TradeType;

public class CommonStockTest {
	
	static CommonStock commonStock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		commonStock = new CommonStock("TEST", StockType.PREFERRED, 13, 2, 100);
		
		// Add some trades
		commonStock.recordTrade(System.currentTimeMillis(), 100, TradeType.BUY, 24.0);
		commonStock.recordTrade(System.currentTimeMillis(), 200, TradeType.SELL, 21.0);
		commonStock.recordTrade(System.currentTimeMillis(), 400, TradeType.BUY, 25.0);
		commonStock.recordTrade(System.currentTimeMillis(), 300, TradeType.SELL, 28.0);
	}

	@Test
	public void testGetDividendYield() {
		double tickerPrice = 25.7;
		try {
			double dividendYield = commonStock.getDividendYield(tickerPrice);
			assertTrue(dividendYield == 0.50583657587548638132295719844358);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}


	@Test
	public void testGetPERatio() {
		double tickerPrice = 25.7;
		try {
			double peRatio = commonStock.getPERatio(tickerPrice);
			assertTrue(peRatio == 1.9769230769230768);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRecordTrade() {
		double tickerPrice = 25.7;
		try {
			commonStock.recordTrade(System.currentTimeMillis(), 100, TradeType.BUY, tickerPrice);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testCalculateStockPriceLast15Mins() {
		try {
			double stockPrice = commonStock.calculateStockPriceLast15Mins();
			assertTrue(stockPrice == 25.0);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

}
