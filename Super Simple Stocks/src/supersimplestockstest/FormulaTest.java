package supersimplestockstest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import supersimplestocks.Formula;
import supersimplestocks.StockException;
import supersimplestocks.Trade;

public class FormulaTest {

	@Test
	public void testGetCommonDividendYield() {
		int lastDividend = 8;
		double tickerPrice = 30.5;
		try {
			double dividendYield = Formula.getCommonDividendYield(lastDividend, tickerPrice);
			assertTrue(dividendYield == 0.26229508196721311475409836065574);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetPreferredDividendYield() {
		int fixedDividend = 2;
		int parValue = 100;
		double tickerPrice = 60;
		try {
			double dividendYield = Formula.getPreferredDividendYield(fixedDividend, parValue, tickerPrice);
			assertTrue(dividendYield == 0.03333333333333333333333333333333);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetPERatio() {
		int dividend = 8;
		double tickerPrice = 40.5;
		try {
			double peRatio = Formula.getPERatio(tickerPrice, dividend);
			assertTrue(peRatio == 5.0625);
			
			} catch (StockException e) {
				fail(e.getMessage());
			}
	}

	@Test
	public void testGetGeometicMean() {
		double[] stockPrices = {2.0, 4.0, 6.0};
		try {
			double geoMean = Formula.getGeometicMean(stockPrices);
			assertTrue(geoMean == 3.634241185664279);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetGeometicMeanLog() {
			double[] stockPrices = {2.0, 4.0, 6.0};
		try {
			double geoMean = Formula.getGeometicMeanLog(stockPrices);
			assertTrue(geoMean == 3.634241185664279);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetStockPrice() {
		ArrayList<Trade> trades = new ArrayList<Trade>();
		Trade trade = new Trade(System.currentTimeMillis(), 100, Trade.TradeType.BUY, 35.0);
		trades.add(trade);
		trade = new Trade(System.currentTimeMillis(), 200, Trade.TradeType.BUY, 32.0);
		trades.add(trade);
		trade = new Trade(System.currentTimeMillis(), 300, Trade.TradeType.BUY, 36.0);
		trades.add(trade);
		try {
			double stockPrice = Formula.getStockPrice(trades);
			assertTrue(stockPrice == 34.5);
		} catch (StockException e) {
			fail(e.getMessage());
		}
	}

}
