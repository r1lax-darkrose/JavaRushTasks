package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String s;
        int count = 0;
        while ((s = reader.readLine()) != null){
            String[] splitS = s.split(" ");
            for (int i = 0; i < splitS.length; i++){
                if (splitS[i].length() > 6){
                    if (count == 0){
                        writer.write(splitS[i]);
                    }else
                        writer.write("," + splitS[i]);
                    count++;
                }
            }
        }
        reader.close();
        writer.close();
    }
}
