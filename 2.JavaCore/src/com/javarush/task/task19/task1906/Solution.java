package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(reader.readLine());//D:\My garbage\Initial.txt
        FileWriter file1 = new FileWriter(reader.readLine());//D:\My garbage\Final.txt
        reader.close();
        int i = 1;
        while (file.ready()){
            int bit = file.read();
            if (i%2 == 0){
                file1.write(bit);
            }
            i++;
        }
        file.close();
        file1.close();
    }
}
