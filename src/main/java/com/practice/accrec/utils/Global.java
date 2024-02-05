package com.practice.accrec.utils;

public class Global {
    public static final int VARCHAR30 = 30;
    public static final int VARCHAR100 = 100;
    public static final int VARCHAR50 = 50;
    public static final int VARCHAR255 = 255;

    // Private constructor to prevent instantiation of the class
    private Global() {
        // This prevents the class from being instantiated
        throw new AssertionError("This class should not be instantiated.");
    }
}
