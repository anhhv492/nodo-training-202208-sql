package networking;

import java.net.*;

public class DatagramClientExample {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            byte[] bytes = "client say xin chao".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,8080);
            socket.send(packet);
            packet = new DatagramPacket(bytes,bytes.length);
            socket.receive(packet);
            System.out.println("from server: "+new String(packet.getData(),0,packet.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
