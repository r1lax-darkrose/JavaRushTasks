package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String id = reader.readLine();
            if (id.equals(""))break;
            String name = reader.readLine();
            if (name.equals("")){
                map.put(name, Integer.parseInt(id));
                break;}
            map.put(name, Integer.parseInt(id));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String name = entry.getKey();
            int num = entry.getValue();
            System.out.println(num + " " + name);
        }
    }
}
