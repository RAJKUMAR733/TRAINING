package org.example;

public class Main {
    public static void main(String[] args) {

        Implementation implementation = new Implementation(9,1,100,100);
        int count = implementation.compute();
        System.out.println(count);
    }
}