package Week12.Lecture.NetworkProgramming;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkProgramming {
    public static void readUrl (String urlAddress) {
        try {
            URL url = new URL(urlAddress);
            System.out.println("URL is ok, protocol is used " + url.getProtocol() + ", " + " and the authority " + url.getAuthority());
        } catch (MalformedURLException e) {
            System.out.println("String " + urlAddress + " is not a valid URL");
        }
    }
    public static void readPageData (String urlAddress) throws IOException{
        URL url = new URL(urlAddress);
        BufferedReader inputStream = new BufferedReader( new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        String content = "";
        String line = null;
        while ((line = inputStream.readLine()) != null) {
            content = content + line;
        }
        String pattern = "h2[^>]*>(.*?)</h2>";

        Pattern regex = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher matcher = regex.matcher(content);

        while (matcher.find()) {
            String h2Content = matcher.group(1);
            System.out.println("Matched h2 content: " + h2Content);
        }
    }
    public static void readSimpleJson() {
        String json = "{ \"key\": \"value\" }";
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("key"));
    }
    public static void readJson(String urlAddress) throws IOException {
        URL url = new URL(urlAddress);
        BufferedReader inputStream = new BufferedReader( new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        String content = "";
        String line = null;
        while ((line = inputStream.readLine()) != null) {
            content = content + line;
        }
        JSONObject jsonObject = new JSONObject(content);
        System.out.println(jsonObject.getJSONObject("record"));
    }
    public static void postExample() throws IOException {
        URL url = new URL("http://localhost:8080/articles/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String jsonInput = "{\"thumbnailUrl\": \"string\", \"title\": \"Hamic\", \"content\": \"Hamigudaa\", \"articleType\": \"SHORT_ARTICLE\"}";
        OutputStream outputStream = connection.getOutputStream();
        byte[] input = jsonInput.getBytes("utf-8");
        outputStream.write(input, 0, input.length);
        System.out.println(connection.getResponseCode());
    }

    public static void main(String[] args) throws IOException{
        //readPageData("https://klix.ba");
        //readSimpleJson();
        //readJson("https://api.jsonbin.io/v3/qs/6580223ddc7465401884b2ba");
        //postExample();
    }
}
