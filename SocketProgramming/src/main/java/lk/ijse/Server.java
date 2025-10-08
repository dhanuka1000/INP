package lk.ijse;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server Started");

            Socket socket=serverSocket.accept();
            System.out.println("Client Accepted");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String massage = dataInputStream.readUTF();
            System.out.println("Client :"+massage);
            socket.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
