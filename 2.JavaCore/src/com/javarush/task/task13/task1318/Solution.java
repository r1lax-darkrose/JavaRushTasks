package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inputStream = new FileInputStream(s);
        while(inputStream.available() > 0){
            char c = (char)inputStream.read();
            System.out.print(c);
        }
        inputStream.close();
        reader.close();
    }
}