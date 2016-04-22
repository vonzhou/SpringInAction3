package com.vonzhou.javainternals;

/**
 * Created by vonzhou on 16/4/16.
 */
public class LearnClass {
    public static void main(String[] args) {
        String[] strArr = new String[10];
        System.out.println(strArr.getClass().getComponentType());
    }
}
