package supersimplestocks;

public class GBCEShareIndex extends ShareIndex {
	private static String shareIndexName = "GBCE";
	private static String[] gbceStocks = {"TEA", "POP", "ALE", "GIN", "JOE"};
	
	public GBCEShareIndex() {
		super(shareIndexName, gbceStocks);
	}
}
