package zimovets.test_task.services;

import java.util.Arrays;

public class DataHandler {

    public static String method1(Long value) {
        System.out.println("Method 1 sleep    " + Thread.currentThread().getName());
        try {
            Thread.sleep(Double.valueOf(Math.random()*2000).longValue() ) ;
        } catch (InterruptedException e) {
        }
        return "Hello, " + value + "!";
    }

    public static String method2(Long value) {
        System.out.println("Method 2 sleep    " + Thread.currentThread().getName());
        try {
            Thread.sleep(Double.valueOf(Math.random()*2000).longValue() ) ;
        } catch (InterruptedException e) {
        }
        return value + "*2 = " + (value * 2) + ".";
    }

    public static String combine(String s1, String s2) {
        System.out.println("Combine   " + Thread.currentThread().getName());
        return s1 + " " + s2;
    }
}
