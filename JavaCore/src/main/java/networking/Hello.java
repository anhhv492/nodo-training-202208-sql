package networking;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public interface Hello extends Remote {
    String say(String name) throws RemoteException;
}
class Server implements Hello{
    @Override
    public String say(String name) throws RemoteException {
        return "hello: "+name;
    }

    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        Server obj = new Server();
        try {
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",8000);
            registry.bind("Hello",stub);
            System.out.println("server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
