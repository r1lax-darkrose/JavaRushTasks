package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileName = new FileInputStream(args[1]);
        FileOutputStream fileOutputName = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            while (fileName.available() > 0){
                int i = fileName.read() + 2;
                fileOutputName.write(i);
            }
        }else if (args[0].equals("-d")){
            while (fileName.available() > 0){
                int i = fileName.read() - 2;
                fileOutputName.write(i);
            }
        }
        fileName.close();
        fileOutputName.close();
    }

}
