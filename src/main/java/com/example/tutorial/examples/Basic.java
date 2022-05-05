package com.example.tutorial.examples;

public class Basic {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int summation(int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        return sum;
    }
}
