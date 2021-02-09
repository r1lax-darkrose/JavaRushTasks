package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        while (file1.available() > 0){
            int currentByte = file1.read();
            list.add(currentByte);
        }
        Collections.reverse(list);
        for (int i : list){
            file2.write(i);
        }

        reader.close();
        file1.close();
        file2.close();
    }
}
