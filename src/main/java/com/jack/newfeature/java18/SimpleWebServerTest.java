package com.jack.newfeature.java18;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class SimpleWebServerTest {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/", new MyHttpHandler());
        httpServer.start();
        System.out.println("JDK 18简单Web服务器已启动，监听端口8000...");
    }
}

class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        String htmlResponse = """
                {
                    "name": "Jack",
                    "age": 18
                }    
                """;
        os.write(htmlResponse.getBytes(Charset.forName("utf-8")));
        os.close();
    }
}