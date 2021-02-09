package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream(args[0]);//"D:/My garbage/Initial.txt"
        int count = 0;
        while (file.available() > 0){
            int i = (char)file.read();
            if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)){
                count++;
            }
        }
        System.out.println(count);
        file.close();
    }
}
