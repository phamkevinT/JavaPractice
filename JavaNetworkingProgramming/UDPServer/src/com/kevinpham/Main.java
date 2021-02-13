package com.kevinpham;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {
            // Create datagram socket that accepts port number
            DatagramSocket socket = new DatagramSocket(5000);

            while (true) {
                // Byte array that accepts data from the socket
                byte[] buffer = new byte[50];
                // Create the packet that will be populated with data from socket
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // Fill that packet with content
                socket.receive(packet);
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));


                // *** Sending packet back to client ***
                // Once server received packet, it uses the address & port from the packet to create a new
                // datagram packet which is then used to send back to client
                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();
                // Get the address from packet received from client
                InetAddress address = packet.getAddress();
                // Get the port from packet received from client
                int port = packet.getPort();
                // Create packet with all information and send it back to client as a response
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet);
            }

        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
