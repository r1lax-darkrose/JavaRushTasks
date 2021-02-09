package com.javarush.task.task20.task2025;

/* 
Алгоритмы-числа
*/

import java.math.BigInteger;
import java.util.TreeSet;

public class Solution {
    public static TreeSet<Long> getNumbers(long N) {

        long[][] numInDegree = numInDegree();

        TreeSet<Long> result = uniqueNum(N, numInDegree);

        return result;

    }

    public static long[][] numInDegree(){

        long[][] array = new long[9][19];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 19; j++){
                array[i][j] = (long) Math.pow(i+1,j+1);
            }
        }

        return array;
    }

    public static TreeSet<Long> uniqueNum(long N, long[][] numInDegree){

        TreeSet<Long> armArray = new TreeSet<>();
        int[] array = new int[String.valueOf(N).length()];



        for (int i = 0; i < array.length; i++){
            array[i] = 9;
        }

        boolean isGoing = true;

        while (isGoing) {

            int countOfNull = countOfNull(array);

            String fckNnum = "";

            for (int i = 0; i < array.length; i++){
                fckNnum += String.valueOf(array[i]);
            }

            BigInteger s = new BigInteger(fckNnum);
            BigInteger armNum = new BigInteger("1");

            for (int i = 0; i < array.length; i++){
                if (array[i] == 0)
                    continue;
                armNum = armNum.multiply(BigInteger.valueOf(numInDegree[array[i]-1][array.length-countOfNull-1]));
            }

            if (s.compareTo(armNum) == 0){
                armArray.add(armNum.longValue());
            }

            array = getNewArr(array, array.length);

            isGoing = array[array.length-1] != 0;
        }

        return armArray;

    }

    public static int countOfNull(int array[]){

        int count = 0;
        int i = 0;
        while (array[i] == 0){
            count++;
            i++;
        }
        return count;
    }

    public static int[] getNewArr(int[] array, int i){
        if (i == 0){
            return array;
        }
        if (array[i-1] != 0){
            i--;
            return getNewArr(array, i);
        }

        array[i] -= 1;
        int temp = array[i];

         for (int j = i-1; j >= 0; j--){
             array[j] = temp;
         }



        return array;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(getNumbers(Long.MAX_VALUE));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
