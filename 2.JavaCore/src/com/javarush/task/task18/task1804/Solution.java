package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        ArrayList<Integer> listOfBytes = new ArrayList<>();
        HashMap<Integer,Integer> mapOfBytes = new HashMap<>();
        while (file.available() > 0){
            int currentByte = file.read();
            listOfBytes.add(currentByte);
        }
        reader.close();
        file.close();
        for (int i = 1; i < 256; i++){
            int freq = Collections.frequency(listOfBytes, i);
            if (freq != 0) {
                mapOfBytes.put(i, freq);
            }
        }
        int minValue = Collections.min(mapOfBytes.values());
        for (Map.Entry<Integer, Integer> pairOfBytes : mapOfBytes.entrySet()){
            if (pairOfBytes.getValue() == minValue){
                System.out.print(pairOfBytes.getKey() + " ");
            }
        }
    }
}
