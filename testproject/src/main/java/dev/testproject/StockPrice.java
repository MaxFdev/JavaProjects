package dev.testproject;

import java.io.*;
import java.net.*;

public class StockPrice {
    public static void main(String[] args) throws IOException {
        String apiKey = /* "YOUR_API_KEY" */"";
        String symbol = "MSFT";
        String urlString = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey;

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content.toString());
    }
}
