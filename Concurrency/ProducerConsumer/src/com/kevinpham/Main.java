package com.kevinpham;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.kevinpham.Main.EOF;


public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<String>();
        // If a thread is already holding a reentrant-lock when it reaches code that requires the same lock, it can proceed without acquiring the lock again
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}

// Add strings from array to buffer
// Finish off by adding EOF
class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding...." + num);
                // Surround code that we want to be thread safe using lock() and unlock().
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    // Must remember to release the lock
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        // Surround code that we want to be thread safe using lock() and unlock().
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            // Must remember to release the lock
            bufferLock.unlock();
        }

    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    // Check if buffer is empty
    // If not, check the value at index 0, and see if value is EOF
    // If value is not EOF, remove entry at index 0 and loop over again
    public void run() {
        while (true) {
            bufferLock.lock();
            // Try-Finally Block ensures that unlock is called no matter the outcome in the try block
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();

            }
        }
    }
}

