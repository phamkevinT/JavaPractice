package com.kevinpham;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();

        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}


//
// wait() - A thread will suspend execution and release whatever lock its holding until
//          another thread issues a notification that something important has happened
// notifyAll() - Issues a notification to waiting threads
//
class Message {
    private String message;
    private boolean empty = true;

    // Used by Consumer
    // Loop until there is a message to read
    // Set empty flag to true to indicate we've read message
    // Return the message
    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    // Used by Producer
    // Loop until message is not empty
    // Set empty flag to false to indicate we've written a message
    // Write the message
    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();

    }

}


/**
 * Producer Class
 */
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

        // Write the messages in the array
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


/**
 * Consumer Class
 */
class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();

        // Loop through messages received and look for the message 'Finished'. Print messages received.
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}