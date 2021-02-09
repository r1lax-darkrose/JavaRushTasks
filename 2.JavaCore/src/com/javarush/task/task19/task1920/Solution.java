package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {

        if(args.length==0) return;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        TreeMap<String,Double> map = new TreeMap<String,Double>();

        String line;
        Double max=null;
        while ((line=reader.readLine())!=null){
            String[] words = line.split("\\s");
            if(words.length < 2) continue;

            map.put(words[0], Double.parseDouble(words[1]) + (map.containsKey(words[0]) ? map.get(words[0]) : 0));
            if ((max==null)||(max<map.get(words[0]))) max = map.get(words[0]);
        }

        reader.close();

        for(Map.Entry<String, Double> e : map.entrySet()){
            if(e.getValue().equals(max))
                System.out.println(e.getKey());
        }

    }
}