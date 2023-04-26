package dev.testproject;

import java.io.*;
import java.net.*;

/*
 * Sure! Here's a brief description of each of the classes being imported in the example:
- `java.io.BufferedReader`: This class reads text from a character-input stream, buffering characters
so as to provide for the efficient reading of characters, arrays, and lines.

- `java.io.IOException`: This class is an exception that signals that an I/O exception of some sort has occurred.
This class is the general class of exceptions produced by failed or interrupted I/O operations.

- `java.io.InputStreamReader`: This class is a bridge from byte streams to character streams.
It reads bytes and decodes them into characters using a specified charset.

- `java.net.HttpURLConnection`: This class is a subclass of `URLConnection` that provides support for
HTTP-specific features. Each instance of this class represents a single HTTP connection to a remote resource.

- `java.net.URL`: This class represents a Uniform Resource Locator, a pointer to a "resource" on the World Wide Web.
*/

public class StockPrice {
    public static void main(String[] args) throws IOException {
        String apiKey = "YOUR_API_KEY";
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
            //System.out.println(inputLine);
        }
        in.close();

        System.out.println(content.toString());
    }
}
