package com.kevinpham;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            while (true) {

                // Kicking off new thread everytime we accept
                Socket socket = serverSocket.accept();
                Echoer echoer = new Echoer(socket);
                echoer.start();

            }


        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }

    }
}
