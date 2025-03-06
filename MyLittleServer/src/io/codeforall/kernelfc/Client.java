package io.codeforall.kernelfc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        int clientPort = 8000;
        int foreignPort = 8080;


        byte[] sendBuffer = new byte[1024];
        byte[] rcvBuffer = new byte[1024];

        DatagramSocket socket;

        try {
            socket = new DatagramSocket(clientPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        DatagramPacket sendPacket = null;
        try {
            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName("localhost"), foreignPort);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            socket.send(sendPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DatagramPacket rcvPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);

        try {
            socket.receive(rcvPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        socket.close();
    }
}


