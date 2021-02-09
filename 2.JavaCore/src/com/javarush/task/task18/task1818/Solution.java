package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();
        String filePath3 = reader.readLine();
        reader.close();
        FileOutputStream file1 = new FileOutputStream(filePath1, true);
        FileInputStream file2 = new FileInputStream(filePath2);
        FileInputStream file3 = new FileInputStream(filePath3);
        while (file2.available() > 0){
            char i = (char)file2.read();
            file1.write(i);
        }
        file2.close();
        while (file3.available() > 0){
            char i = (char)file3.read();
            file1.write(i);
        }
        file3.close();
        file1.close();
    }
}
