package com.angelmtzr.threadjoinexample;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class MyThread extends Thread {
    private final DataCenter data;

    public MyThread(DataCenter data, String name) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            var variations = new ArrayList<>(List.of(-1, 1));
            int randIndex = RandomGenerator.getDefault().nextInt(variations.size());
            data.setValue(data.getValue() + variations.get(randIndex));
        }
    }
}
