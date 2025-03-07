package io.codeforall.kernelfc;

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {

        int port = 8080;
        String host = "localhost";
        ServerSocket serverSocket;
        Socket clientSocket;
        BufferedReader in;
        OutputStream out;
        File fileHtml = new File("www/index.html");
        FileReader fileReader = new FileReader(fileHtml);
        byte[] fileHtmlContent = Files.readAllBytes(fileHtml.toPath());

        serverSocket = new ServerSocket(port);


        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Connection accepted");
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = clientSocket.getOutputStream();

                System.out.println(in.readLine());


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("I'm here before the response");
            out.write(("HTTP/1.0 200 Document Follows\r\n" +
                    "Content-Type: index/html; charset=UTF-8\r\n" +
                    "Content-Length: <" + fileHtml.length() + "> \r\n" +
                    "\r\n").getBytes());

            out.write(fileHtmlContent);

            out.flush();

            System.out.println("I'm here after response");


        }
    }
}
