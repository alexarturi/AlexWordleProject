import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WordSource {
    private String word;
    public String getWord() {
        ByteArrayOutputStream responseBodyBaos = null;
        Scanner httpResponseBodyScanner = null;
        try {
            // Define server endpoint
            URL robotsUrl = new URL("https://random-word-api.herokuapp.com/word?length=5");
            HttpURLConnection urlConnection = (HttpURLConnection) robotsUrl.openConnection();

            httpResponseBodyScanner = new Scanner(urlConnection.getInputStream());

            // Use a ByteArrayOutputStream to store the contents of the HTTP response body
            responseBodyBaos = new ByteArrayOutputStream();
            while (httpResponseBodyScanner.hasNextLine()) {
                responseBodyBaos.write(httpResponseBodyScanner.nextLine().getBytes());
            }
            responseBodyBaos.close();
            httpResponseBodyScanner.close();

            // Verify contents of robots.txt
            String robotsContent = responseBodyBaos.toString().substring(2, 7);
            return robotsContent;

        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        } finally {
            if (responseBodyBaos != null) {
                try {
                    responseBodyBaos.close();
                } catch (IOException ioe) {
                    return null;
                }
            }
            if (httpResponseBodyScanner != null) {
                httpResponseBodyScanner.close();
            }
        }
    }
}
