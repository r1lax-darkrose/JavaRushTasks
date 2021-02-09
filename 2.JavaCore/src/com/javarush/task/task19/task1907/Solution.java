package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int count = 0;
        while (reader1.ready()){
            String[] strings = reader1.readLine().split("[ ,.]");
            for (int i = 0; i < strings.length; i++){
                if (strings[i].equalsIgnoreCase("world")){
                    count++;
                }
            }
        }
        reader1.close();
        System.out.println(count);
    }
}
