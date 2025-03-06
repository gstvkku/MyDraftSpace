package io.codeforall.kernelfc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        int portNum = 8080;

        try {
            serverSocket = new ServerSocket(portNum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String message = "Hello";

        while (message != null) {

                message = in.readLine();
                
            if(message != null) {
                try {
                    out.print(clientSocket.getInputStream());
                    System.out.println(message);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
