package com.angelmtzr.threadjoinexample;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var data = DataCenter.getInstance(0);

        LOGGER.log(Level.INFO, "Initial value: " + data.getValue());

        ArrayList<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var t = new MyThread(data, String.valueOf(i));
            t.start();
            threads.add(t);
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARNING, "Thread " + t.getName() + " was interrupted.");
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOGGER.log(Level.INFO, "Final value: " + data.getValue());
    }
}