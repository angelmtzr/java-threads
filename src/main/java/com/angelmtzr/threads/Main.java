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

        // Make the main thread wait for all created threads to finish.
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARNING,
                        "Thread " + t.getName() + " was interrupted while " + t.getState() + ":\n" + e);
            }
        });

        LOGGER.log(Level.INFO, "Final value: " + dc.getValue());
    }
}