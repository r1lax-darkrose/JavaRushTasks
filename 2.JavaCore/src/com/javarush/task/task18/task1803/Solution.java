package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        ArrayList<Integer> listOfBytes = new ArrayList<>();
        while (file.available() > 0){
            int currentByte = file.read();
            listOfBytes.add(currentByte);
        }
        Map<Integer, Integer> mapOfBytes = new HashMap<>();
        for (int i = 1; i < 256; i++){
            int freq = Collections.frequency(listOfBytes, i);
            if (freq != 0) {
                mapOfBytes.put(i, freq);
            }
        }
        int maxValue = Collections.max(mapOfBytes.values());
        for (Map.Entry<Integer, Integer> pairOfMap : mapOfBytes.entrySet()){
            if (pairOfMap.getValue() == maxValue){
                System.out.print(pairOfMap.getKey() + " ");
            }
        }
        reader.close();
        file.close();
    }
}
