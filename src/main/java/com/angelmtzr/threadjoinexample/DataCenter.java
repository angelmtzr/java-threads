package com.angelmtzr.threadjoinexample;

public final class DataCenter {
    private static DataCenter instance;
    private int value;
    public boolean isBusy = false;

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

    /**
     * Increments the value of this DataCenter by the given amount.
     *
     * @param amount the value of the increment amount.
     */
    public void incrementValue(int amount) {
        setValue(getValue() + amount);
    }

    /**
     * Decrements the value of this DataCenter by the given amount.
     *
     * @param amount the value of the decrement amount.
     */
    public void decrementValue(int amount) {
        setValue(getValue() - amount);
    }
}
