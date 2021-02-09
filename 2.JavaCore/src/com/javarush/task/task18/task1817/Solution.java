package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream file = new FileInputStream(args[0]);//"D:/My garbage/Initial.txt"
        int countOfSpace = 0, countOfChars = 0;
        while (file.available() > 0){
            int i = file.read();
            if (i == 32){
                countOfSpace++;
            }
                countOfChars++;
        }
        file.close();
        //System.out.println((float) countOfSpace/countOfChars*100);
        System.out.println(new BigDecimal((float) countOfSpace/countOfChars*100).setScale(2, RoundingMode.HALF_EVEN));
    }
}
