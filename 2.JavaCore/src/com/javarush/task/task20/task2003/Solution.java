package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        load(file);
        FileOutputStream file1 = new FileOutputStream("D:/My garbage/Final.txt");
        save(file1);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String, String> bitOfMap : properties.entrySet()){
            prop.setProperty(bitOfMap.getKey(), bitOfMap.getValue());
        }
        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach((key, value) -> properties.put((String) key, (String) value));
    }

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        for (Map.Entry<String, String> map : properties.entrySet()){
            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }
}
