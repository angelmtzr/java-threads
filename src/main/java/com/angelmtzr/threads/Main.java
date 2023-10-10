package com.angelmtzr.threads;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {
        // Instance the object that will be shared across threads
        var dc = DataCenter.getInstance(0);

        LOGGER.log(Level.INFO, "Initial value: " + dc.getValue());

        // Create the threads with the same data object and start them
        var threads = new ArrayList<MyThread>();
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            var t = new MyThread(dc, String.valueOf(i));
            threads.add(t);
            t.start();
        }

        // Print the threads's states until all threads have finished
        boolean aThreadIsAlive;
        do {
            // TODO: For some reason it is only running once. With and without sleep.
            LOGGER.log(Level.INFO, "Active Threads: " + Thread.activeCount());
            threads.forEach(t -> LOGGER.log(Level.INFO, "Thread " + t.getName() + ": " + t.getState()));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARNING, "Main thread was interrupted while sleeping:\n" + e);
            }
            aThreadIsAlive = threads.stream().anyMatch(t -> t.isAlive());
        } while (aThreadIsAlive);

        LOGGER.log(Level.INFO, "Final value: " + dc.getValue());
    }
}