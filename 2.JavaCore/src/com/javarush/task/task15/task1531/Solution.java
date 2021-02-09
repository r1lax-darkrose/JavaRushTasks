package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n == 0){
            return "1";
        }
        if (n < 0){
            return "0";
        }
        BigInteger bigInteger = BigInteger.valueOf(n);
        BigInteger bigInteger1 = new BigInteger("1");
        BigInteger bigInteger2 = new BigInteger("1");

        while (!bigInteger.equals(bigInteger2)){
            bigInteger1 = bigInteger.multiply(bigInteger1);
            bigInteger = bigInteger.subtract(bigInteger2);
        }
        return bigInteger1.toString();
    }
}
