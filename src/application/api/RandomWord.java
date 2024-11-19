package application.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RandomWord {
    public static String getRandomWord() throws IOException {
        String result;
        do {
            URL url = new URL("https://random-word-api.herokuapp.com/word?length=5");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            result = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            result = result.substring(2, result.length() - 2);
        } while (!Dictionary.verifyWordValidity(result));

        return result.toUpperCase();
    }
}
