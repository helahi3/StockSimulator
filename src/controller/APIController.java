package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Wrapper for the AlphaVantage API
 * Limited use, only wrapping the necessary function
 * Get the stock price in JSON format
 * @author Hamza
 *
 */
public class APIController {
	
	
	static final String apiKey = "WBFOAOCT38SFVAQA";

    
    /**
     * Checks the alpha vantage api to get the stock price of the object
     * @param symbol you wish to get the price for
     * @return the current stock price. Returns -1 if error
     */
    public static Double getStockPrice(String symbol) {
    	//TODO: Http connection check
    	
    	String link = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + symbol +"&interval=1min&apikey=WBFOAOCT38SFVAQA";
    	URL url;
	    JsonParser jp = new JsonParser(); //from gson

		try {
			url = new URL(link);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String jsonText = readAll(br);
			
			//Parse the string into a JsonElement, convert to a JsonObject
			//Systematically move down to get the stock price at the current time
			//TODO: Refactor into cleaner code
		    JsonElement root = jp.parse(jsonText); 
		    JsonObject jsonObj = root.getAsJsonObject();  
   

		    JsonObject jsonTimeSeries = jsonObj.get("Time Series (1min)").getAsJsonObject();
		    
		    //Get the latest dateTime key...
		    Set<Map.Entry<String, JsonElement>> entries = jsonTimeSeries.entrySet();
		    String dateTime = "";
		    for (Map.Entry<String, JsonElement> entry: entries) {
		         dateTime = entry.getKey();
		         break;
		    }

		    //..and use that key to get the latest pricing info 
		    JsonObject currentTime = jsonTimeSeries.get(dateTime).getAsJsonObject();
		    String stringPrice = currentTime.get("1. open").getAsString();
		    Double currentPrice = Double.parseDouble(stringPrice);

		    return currentPrice;
		    
					
		} catch (Exception e) {
			return -1.0; //Return -1 if exception
			//TODO: Add more comprehensive checks of the error
		}
    }
    
    /**
	 * Code from StackOverflow TODO: Reformat it
     * @param Reader to parse
     * @return the input in String format
     * @throws IOException
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }

}
