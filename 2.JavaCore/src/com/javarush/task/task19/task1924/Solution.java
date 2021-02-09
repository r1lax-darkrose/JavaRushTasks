package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader filereader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fReader = new FileReader(filereader.readLine());

        filereader.close();
        filereader = new BufferedReader(fReader);
        Matcher m;
        while(filereader.ready()){
            String s=filereader.readLine();
            for(Map.Entry<Integer,String> pair : map.entrySet()){
                m=Pattern.compile("((^| )"+pair.getKey()+"( |$))").matcher(s);
                while(m.find())
                    s=s.replaceAll(m.group(1), m.group(2)+pair.getValue()+m.group(3));
            }
            System.out.println(s);
        }
        fReader.close();
        filereader.close();
    }
}
