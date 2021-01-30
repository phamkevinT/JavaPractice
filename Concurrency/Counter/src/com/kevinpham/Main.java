package com.kevinpham;

public class Main {

    // Take away lessons:
    //
    // 1. LOCAL variables are stored in the thread STACK, each thread has its own copy of the variable
    // 2. Memory required to store an INSTANCE variable value is located on the HEAP, thread share same object
    // 3. Thread could be suspended between steps (for example, before decrementing i in the for-loop, just before condition check)
    // 4. Thread interference (Race condition) - thread interfere with each other and change value of i
    // 5. Synchronization - Control when thread execute code and therefore when they can access the heap
    //
    //

    public static void main(String[] args) {

        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");


        t1.start();
        t2.start();
    }
}


class Countdown {

    private int i;

    // Adding 'synchronized' before void allows only one thread to access the entire method at a time
    public void doCountDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        // Only one thread can hold the 'countDown' object at a time so only one thread can execute the code block at a time
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i=" + i);
            }
        }

    }
}


class CountdownThread extends Thread {
    private Countdown threadCountDown;

    public CountdownThread(Countdown countdown) {
        threadCountDown = countdown;
    }

    public void run() {
        threadCountDown.doCountDown();
    }
}
