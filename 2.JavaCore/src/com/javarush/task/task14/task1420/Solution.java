package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseUnsignedInt(reader.readLine()), b = Integer.parseUnsignedInt(reader.readLine());
        if (a <= 0 || b <= 0){
            throw new Exception();
        }
        while (a != b){
            if (a > b){
                a = a - b;
            }
            else{
                b = b - a;
            }
        }
        System.out.println(a);
    }
}
