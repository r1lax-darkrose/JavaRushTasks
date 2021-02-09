package com.javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        List<Integer> list = new ArrayList<>();
        while(fileReader.ready()){
             list.add(Integer.parseInt(fileReader.readLine()));
        }
        fileReader.close();
        Collections.sort(list);
        for (int i : list){
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
