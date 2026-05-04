package labs.example.chatbot;

import java.net.URI;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            // 1. Build the URI for the Gemini model
            URI uri = new URI("https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent");
            
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("POST");
            
            // 2. Add the required Gemini API Key header
            conn.setRequestProperty("x-goog-api-key", System.getenv("AIzaSyCkf4iCzeaHq8ORKXnxGQSH7U59TtzIILc"));
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // 3. Construct the JSON request body
            String jsonBody = "{ \"contents\": [ { \"parts\": [ { \"text\": \"Explain what AI is in one sentence.\" } ] } ] }";
            
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 4. Read the response
            try (Scanner scanner = new Scanner(conn.getInputStream(), "UTF_8")) {
                String response = scanner.useDelimiter("\\A").next();
                System.out.println(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
