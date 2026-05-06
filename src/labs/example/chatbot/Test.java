package labs.example.chatbot;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class Test {
    public static void main(String[] args) {
            String apiKey = "";
            // The endpoint usually looks like this
            String urlString = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;

            try {
                URI uri = new URI(urlString);
                URL url = uri.toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                // Configure Connection
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json; utf-8");
                conn.setDoOutput(true);

                // 2. Define the JSON Payload
                // Gemini requires a specific "contents" -> "parts" -> "text" structure
                String jsonBody = "{"
                    + "\"contents\": [{"
                    + "  \"parts\":[{\"text\": \"Explain how AI works in a few sentences.\"}]"
                    + "}]"
                    + "}";

                // 3. Write the Request Body
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                // 4. Read the Response
                int status = conn.getResponseCode();
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                        status < 300 ? conn.getInputStream() : conn.getErrorStream(), 
                        StandardCharsets.UTF_8
                    )
                );

                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                System.out.println("Status: " + status);
                System.out.println("Response: " + response.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
