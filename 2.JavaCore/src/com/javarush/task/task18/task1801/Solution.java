package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        long countOfByte = 0;
        while (file.available() > 0){
            int num = file.read();
            if (countOfByte < num){
                countOfByte = num;
            }
        }
        System.out.println(countOfByte);
        reader.close();
        file.close();
    }
}
