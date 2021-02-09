package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));//D:/My garbage/Initial.txt
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));//D:/My garbage/Final.txt
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher;
        String line;
        while ((line = reader.readLine()) != null){
            String[] eachWord = line.split(" ");
            for (int i = 0; i < eachWord.length; i++){
                matcher = pattern.matcher(eachWord[i]);
                if (matcher.find()){
                    writer.write(eachWord[i] + " ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
