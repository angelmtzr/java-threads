package com.angelmtzr.threads;

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
            data.incrementValue(1);
        }
    }
}
