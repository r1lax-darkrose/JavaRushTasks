package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        String s;
        while ((s = reader1.readLine()) != null){
            String[] data = s.split(" ");
            if (Integer.parseInt(data[0]) == Integer.parseInt(args[0])){
                System.out.println(Integer.parseInt(data[0]) + "\n" + data[1] + "\n" + Double.parseDouble(data[2]) + "\n" + Integer.parseInt(data[3]));
            }
        }
        reader1.close();
        reader.close();

    }
}
