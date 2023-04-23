package org.example;

import static org.example.GenereicSort.sort;

public class Main {

    public static void main(String[] args) {
        Integer[]arr={2,1,4,5,3};
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        sort(arr);
        sort(doubleArray);
        sort(charArray);
        for(Integer i:arr)
        {
            System.out.println(i);
        }
        for(Double d:doubleArray)
        {
            System.out.println(d);
        }
        for(Character c:charArray)
        {
            System.out.println(c);
        }
    }
}