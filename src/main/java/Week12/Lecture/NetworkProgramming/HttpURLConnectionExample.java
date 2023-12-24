package Week12.Lecture.NetworkProgramming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {
    public static void postExample () throws IOException {
        URL url = new URL("http://localhost:8080/articles/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String jsonInput = "{\"thumbnailUrl\": \"string\", \"title\": \"Hamic\", \"content\": \"Hamigudaa\", \"articleType\": \"SHORT_ARTICLE\"}";
        OutputStream outputStream = connection.getOutputStream();
        byte [] input = jsonInput.getBytes("utf-8");
        outputStream.write(input, 0, input.length);
        System.out.println(connection.getResponseCode());

    }

    public static void main(String[] args){
        try {
            postExample();
        } catch (IOException e) {
            System.out.println("Unable to connect.");
        }
    }
}
