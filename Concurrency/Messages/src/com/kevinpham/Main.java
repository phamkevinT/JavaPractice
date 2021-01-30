package com.kevinpham;

import java.util.Random;

public class Main {

    public static void main(String[] args) {


    }
}


class Message {
    private String message;
    private boolean empty = true;

    // Used by Consumer
    // Loop until there is a message to read
    // Set empty flag to true to indicate we've read message
    // Return the message
    public synchronized String read() {
        while (empty) {

        }
        empty = true;
        return message;
    }

    // Used by Producer
    // Loop until message is not empty
    // Set empty flag to false to indicate we've written a message
    // Write the message
    public synchronized void write(String message) {
        while (!empty) {

        }
        empty = false;
        this.message = message;
    }

}


class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty Dumpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}