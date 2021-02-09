package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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
        FileInputStream inFile1 = new FileInputStream(filePath1);
        byte[] bytesOfFile1 = new byte[inFile1.available()];
        int j = 0;
        while (inFile1.available() > 0){
            bytesOfFile1[j] = (byte) inFile1.read();
            j++;
        }
        inFile1.close();
        FileOutputStream outFile1 = new FileOutputStream(filePath1);
        FileInputStream file2 = new FileInputStream(filePath2);
        byte[] bytes = new byte[file2.available()];
        int i = 0;
        while (file2.available() > 0) {
            bytes[i] = (byte) file2.read();
            i++;
        }
            file2.close();
            outFile1.write(bytes);
            outFile1.write(bytesOfFile1);
            outFile1.close();

    }
}
