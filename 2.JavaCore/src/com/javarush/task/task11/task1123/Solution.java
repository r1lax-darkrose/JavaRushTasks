package com.javarush.task.task11.task1123;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
        int[] array = new int[inputArray.length];

        for (int i = 0; i < array.length; i++){
            array[i] = inputArray[i];

        }

        for (int i = 1; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                if (array[i-1] > array[j]){
                    int count = array[i - 1];
                    array[i - 1] = array[j];
                    array[j] = count;
                }
            }
        }


        return new Pair<Integer, Integer>(array[0], array[array.length-1]);
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
