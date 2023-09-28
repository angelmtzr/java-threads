package com.angelmtzr.threadjoinexample;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        var data = DataCenter.getInstance(0);
        for (int i = 0; i < 5; i++) {
            var t = new MyThread(data, String.valueOf(i));
            t.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Logger.getLogger(Main.class.getName()).info(String.valueOf(data.getValue()));
    }
}