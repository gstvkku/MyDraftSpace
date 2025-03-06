package io.codeforall.kernelfc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        while (true) {
            String hostName = "localhost";
            int serverPort = 8080;
            int foreignPort;

            byte[] sendBuffer = new byte[1024];
            byte[] rcvBuffer = new byte[1024];

            DatagramSocket socket;

            try {
                socket = new DatagramSocket(serverPort);
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }

            DatagramPacket rcvPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);

            try {
                socket.receive(rcvPacket);
                foreignPort = rcvPacket.getPort();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String text;
            try {
                text = new String(rcvPacket.getData(), 0, rcvPacket.getLength(), "UTF-8").toUpperCase();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            sendBuffer = text.getBytes();

            try {
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, rcvPacket.getAddress(), foreignPort);
                    socket.send(sendPacket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            socket.close();
    }
        }

}
