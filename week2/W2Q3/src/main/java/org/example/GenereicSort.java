package org.example;

import java.util.Arrays;

public class GenereicSort {
    public static < T extends Comparable<T>> void sort(T[]array){
        Arrays.sort(array);
    }
    public static <T> void printArray(T[]inputArray){
        for(T obj:inputArray)
        {
            System.out.println(obj);
        }
    }
}
