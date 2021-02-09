package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        reader.close();
        while (fileReader.ready()){
            Matcher matcher = pattern.matcher(fileReader.readLine());
            while (matcher.find()){
                fileWriter.write(Integer.parseInt(matcher.group()) + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
