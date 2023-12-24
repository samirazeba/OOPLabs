package Week12.Lecture.NetworkProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExample {
    public static void socketServer (int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(2345);
            while (true) {
                java.net.Socket connection = serverSocket.accept();
                InputStream inputStream = connection.getInputStream();

                //Read data from the client
                byte [] buffer = new byte[1024];
                int bytetsRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytetsRead);
                System.out.println("Received message from client: " + message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void socketClient(String address, int port) {
        try {
            Socket connection = new Socket(address, port);
            OutputStream outputStream = connection.getOutputStream();

            outputStream.write("Hello server!".getBytes());

            outputStream.close();
            connection.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        socketClient("192.168.1.13", 2345);
        //socketServer(2345);
    }
}
