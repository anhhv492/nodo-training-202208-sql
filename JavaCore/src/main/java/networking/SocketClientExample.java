package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);
        System.out.println("Client start sending");
        try(DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
            output.writeUTF("Hello server");
            System.out.println("server say: "+input.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            socket.close();
        }
    }
}
