package com.kevinpham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Socket
        try (Socket socket = new Socket("localhost", 5000)) {

            // Set a timeout
            socket.setSoTimeout(5000);
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            // Take console input string to send to server
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                // Write to server
                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    // Get response from server
                    response = echoes.readLine();
                    // Print response from server
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e) {
            System.out.println("The socket Timed out");
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }

    }
}
