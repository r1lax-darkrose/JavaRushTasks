package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        FileOutputStream file1 = new FileOutputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());

        byte[] bytesSmall = new byte[file.available()/2];
        byte[] bytesBig = new byte[file.available() - bytesSmall.length];

        for (int i = 0; i < bytesBig.length; i++){
            bytesBig[i] = (byte) file.read();
        }
        for (int i = 0; i < bytesSmall.length; i++){
            bytesSmall[i] = (byte)file.read();
        }
        file1.write(bytesBig);
        file2.write(bytesSmall);


        reader.close();
        file.close();
        file1.close();
        file2.close();
    }
}
