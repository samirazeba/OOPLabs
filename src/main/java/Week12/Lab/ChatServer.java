package Week12.Lab;

import Week3.LabDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<ClientHandler> clients = new ArrayList<>();

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(sender.getUsername() + ": " + message);
            }
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(12345);
    }
    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try{
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream(), true);

                printWriter.println("Enter your username: ");
                username = bufferedReader.readLine();
                printWriter.println("Welcome to the chat, " + username);
                broadcastMessage(username + " has joined the chat.", this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public String getUsername () {
            return username;
        }
        public void sendMessage(String message) {
            printWriter.println(message);
        }

        @Override
        public void run() {
            try {
                String clientMessage;
                while ((clientMessage = bufferedReader.readLine()) !=  null) {
                    broadcastMessage(clientMessage, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(this);
                broadcastMessage(username + " has left the chat.", this);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
