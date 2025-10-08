package lk.ijse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket remoteSocket = new Socket("localhost", 8888);
            DataOutputStream out = new DataOutputStream(remoteSocket.getOutputStream());
            out.writeUTF("Hello Server");
            out.flush();
            out.close();
            remoteSocket.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}