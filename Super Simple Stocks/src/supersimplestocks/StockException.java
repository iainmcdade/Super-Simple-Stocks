package supersimplestocks;

public class StockException extends Exception {

	private static final long serialVersionUID = 1L;

	StockException(String reason) {
		super(reason);
	}
}
