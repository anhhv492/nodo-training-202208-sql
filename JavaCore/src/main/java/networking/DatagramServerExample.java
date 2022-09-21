package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class DatagramServerExample implements Runnable{
    DatagramServerExample() throws SocketException {
        DatagramSocket socket = new DatagramSocket(4445);
        System.out.println("Data server listening");
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(8080);
            byte[] bytes = new byte[50];
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
            System.out.println("From client: "+new String(packet.getData(),0,packet.getLength()));
            bytes = "server say hello".getBytes();
            socket.send(new DatagramPacket(bytes,bytes.length,packet.getAddress(),packet.getPort()));
            socket.receive(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            try {
                new DatagramServerExample();
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
