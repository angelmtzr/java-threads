package com.angelmtzr.threadjoinexample;

public final class DataCenter {
    private static DataCenter instance;
    private int value;

    private DataCenter(int value) {
        setValue(value);
    }

    public static DataCenter getInstance(int value) {
        if (instance == null) {
            instance = new DataCenter(value);
        }
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
