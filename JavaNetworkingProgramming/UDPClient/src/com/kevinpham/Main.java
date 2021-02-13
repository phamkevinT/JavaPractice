package com.kevinpham;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            // Get the address of host that we want to send data to
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                // Convert user input into byte array
                byte[] buffer = echoString.getBytes();

                // Creating the packet
                // Datagram is self-contained message. It has data, address and port number if the server wants to respond.
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);

                // *** Setup to receive response from Server ***
                // Typically don't expect to receive response with UDP. This is for demo. ***
                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));

            } while (!echoString.equals("exit"));


        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }

    }
}
