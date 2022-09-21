package networking;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) throws Exception{
        String link = "http://cooc.net/";
        URL url = new URL(link);
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();
        int read;
        byte[] bytes = new byte[50];
        while ((read=stream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));
        }
    }
}
