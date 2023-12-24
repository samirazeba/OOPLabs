package Week12.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server_ip>");
            System.exit(1);
        }
        String username = args[0];
        String serverIP = args[1];
        int serverPort = 12345;

        try (Socket socket = new Socket(serverIP, serverPort)){
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader( new InputStreamReader(System.in));

            printWriter.println(username);

            new Thread( () -> {
                try {
                    String serverMessage;
                    while ((serverMessage = bufferedReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }) .start();

            String clientMessage;
            while ((clientMessage = consoleReader.readLine()) != null) {
                printWriter.println(clientMessage);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
