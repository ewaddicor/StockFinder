import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.DecimalFormat;

public class StockQuote {

	private String ticker;

	private double currentPrice;
	private double priceChange;
	private double high;
	private double low;

	public StockQuote() {
	}

	public StockQuote(String ticker) {
		this.ticker = ticker;
		
		DecimalFormat number = new DecimalFormat();
		DecimalFormat dollars = new DecimalFormat("$#,##0.00;-$#,##0.00");
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		
		String api_key = "5Q9EJ2JGU61SXQQD";
		
		try {
			// Retrieves data from Alpha Vantage in .csv format:
			// symbol,open,high,low,price,volume,latestDay,previousClose,change,changePercent
			URL url = new URL("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + ticker + "&apikey=" + api_key + "&datatype=csv");
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			in.readLine(); // skips header row
			String quoteString = in.readLine();
			in.close();
			
			if (quoteString == null) {
				System.out.println("Requested data is not available.");
				System.exit(0);
			}
			
			// Splits stock data by column
			String[] data = quoteString.split(",");
			if (data.length != 10) {
				System.out.println("Bad output: " + quoteString);
				System.exit(0);
			}

			high = Double.parseDouble(data[2]);
			low = Double.parseDouble(data[3]);
			currentPrice = Double.parseDouble(data[4]);
			double previousClose = Double.parseDouble(data[7]);
			priceChange = currentPrice - previousClose;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setticker(String ticker) {
		this.ticker = ticker;
	}
	
	public String getticker() {
		return ticker;
	}
	
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public double getCurrentPrice() {
		return currentPrice;
	}
	
	public void setPriceChange(double priceChange) {
		this.priceChange = priceChange;
	}
	
	public double getPriceChange() {
		return priceChange;
	}
	
	public void setHigh(double high) {
		this.high = high;
	}
	
	public double getHigh() {
		return high;
	}
	
	public void setLow(double low) {
		this.low = low;
	}
	
	public double getLow() {
		return low;
	}
}