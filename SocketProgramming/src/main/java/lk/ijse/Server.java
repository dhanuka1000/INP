package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server Started");

            Socket socket=serverSocket.accept();
            System.out.println("Client Accepted");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String massage = dataInputStream.readUTF();
            System.out.println("Client :"+massage);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Server Received Input Name");
            out.flush();
            out.close();
            socket.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
