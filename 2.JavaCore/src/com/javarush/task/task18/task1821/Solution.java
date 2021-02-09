package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        for (int i = 0; i <= 127; i++){
            FileInputStream file = new FileInputStream(args[0]);
            int count = 0;
            int num;
            while ((num = file.read()) != -1){

                if (num == i){
                    count++;
                }
            }
            if (count != 0) {
                System.out.println((char) i + " " + count);
            }
            file.close();
        }
    }
}
