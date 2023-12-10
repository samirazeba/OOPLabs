package Week10;

import java.io.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Events {

    private static final int RECORDS = 1000000;
    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
    public static void generateEventsFile(String filename) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(filename)
        );
        Random random = new Random();
        for (int i = 0; i < RECORDS; i++) {
            int timestamp = random.nextInt(Integer.MAX_VALUE);
            String eventType = EVENT_TYPES[random.nextInt(EVENT_TYPES.length)];
            int userID = random.nextInt(1000);

            bufferedWriter.write(timestamp + "\n" + eventType + "\n" + userID);
        }
        bufferedWriter.close();
    }

    public static void readEventsFile(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filename)
        );
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        int iterations = 1;
        for (int i = 0; i < 5; i++) {
            for (String line : lines) {
                System.out.println(line);
            }
            iterations = (iterations % 5) + 1;
        }
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException{
        String filename = "events.txt";

        generateEventsFile(filename);
        readEventsFile(filename);
    }
}
