package networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message="<html><h2>Viet Anh</h2></html>";
        exchange.sendResponseHeaders(200,message.length());
        try(OutputStream outputStream = exchange.getResponseBody()){
            outputStream.write(message.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
