package com.kevinpham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            // Socket instance that is used to communicate with the client
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            // IO Stream to send and receive data from client
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Read data from the client and print message
            while (true) {
                String echoString = input.readLine();
                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }


        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }

    }
}
