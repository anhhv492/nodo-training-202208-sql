package networking;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.locks.Lock;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",8000);
            Hello stub = (Hello) registry.lookup("hello");
            System.out.println("response: "+stub.say(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
