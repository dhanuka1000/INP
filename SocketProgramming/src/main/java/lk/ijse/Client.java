package lk.ijse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Name :");
        String name = sc.nextLine();

        try{
            Socket remoteSocket = new Socket("localhost", 8888);

            DataOutputStream out = new DataOutputStream(remoteSocket.getOutputStream());
            out.writeUTF(name);
            out.flush();
            out.close();
            remoteSocket.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}