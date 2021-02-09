package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        //FileInputStream file1 = new FileInputStream("D:/My garbage/Initial.txt");
        //FileOutputStream file2 = new FileOutputStream("D:/My garbage/Final.txt");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(reader1.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader1.readLine()));
        String[] floats = reader.readLine().split(" ");
        for (int i = 0; i < floats.length; i++){
            writer.write(Math.round(Float.parseFloat(floats[i])) + " ");
        }
        reader1.close();
        reader.close();
        writer.close();
    }
}
