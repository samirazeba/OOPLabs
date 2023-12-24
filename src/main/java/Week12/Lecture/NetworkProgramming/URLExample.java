package Week12.Lecture.NetworkProgramming;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class URLExample {
    public static void readUrl (String urlAddress) {
        try {
            URL url = new URL(urlAddress);
            System.out.println("URL is ok, protocol used is " +
                    url.getProtocol() + ", and the authority " +
                    url.getAuthority());
        } catch (MalformedURLException e) {
            System.out.println("String " + urlAddress + " is not a valid URL.");
        }
    }
    public static void readPageData (String urlAddress) throws IOException {
        URL url = new URL(urlAddress);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
        );
        String content = "";
        String line = null;
        while ((line = reader.readLine()) != null) {
            content += line;
        }
    }
    public static void readSimpleJson () {
        String json = " { \"key\" : \"value\" }";
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("key"));
    }
    public static void readJson (String urlAddress) throws IOException {
        URL url = new URL(urlAddress);
        BufferedReader inputStream = new BufferedReader( new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        String content = "";
        String line = null;
        while ((line = inputStream.readLine()) != null) {
            content = content + line;
        }
        JSONObject jsonObject = new JSONObject(content);
        System.out.println(jsonObject.getJSONObject("record").getJSONArray("likes0"));
    }

    public static void main(String[] args) throws IOException{
        //readUrl("https://www.klix.ba/");
        //readPageData("https://www.klix.ba/");
        //readSimpleJson();
        readJson("https://www.klix.ba/");
    }
}
