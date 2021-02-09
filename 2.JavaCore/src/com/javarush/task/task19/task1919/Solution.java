package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> mapOfSallary = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null){
            String[] splitLine = line.split(" ");
            if (mapOfSallary.containsKey(splitLine[0])){
                double num = mapOfSallary.get(splitLine[0]) + Double.parseDouble(splitLine[1]);
                mapOfSallary.replace(splitLine[0], mapOfSallary.get(splitLine[0]), num);
            }else
                mapOfSallary.put(splitLine[0], Double.parseDouble(splitLine[1]));
        }
        reader.close();
        for (Map.Entry e : mapOfSallary.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
