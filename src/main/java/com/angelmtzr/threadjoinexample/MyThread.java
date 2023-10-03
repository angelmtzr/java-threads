package com.angelmtzr.threadjoinexample;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread extends Thread {
    private final DataCenter data;
    private static final int TOTAL_ITERATIONS = 1_000;

    private static final Logger LOGGER = Logger.getLogger(MyThread.class.getName());

    public MyThread(DataCenter data, String name) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < TOTAL_ITERATIONS; i++) {
            while (data.isBusy) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.WARNING,
                            "Thread " + getName() + " was interrupted while " + getState() + ":\n" + e);
                }
            }
            data.isBusy = true;
            data.incrementValue(1);
            data.isBusy = false;
        }
    }
}
