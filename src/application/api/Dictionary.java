package application.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Dictionary {
    public static boolean verifyWordValidity(String word) throws IOException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        return connection.getResponseCode() != 404;
    }
}
