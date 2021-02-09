package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));//D:/My garbage/Initial.txt
        reader.close();
        String s;
        while ((s = reader1.readLine()) != null){
            String[] s1 = s.split(" ");
            int count = 0;
            for (int i = 0; i < words.size(); i++){
                for (int j = 0; j < s1.length; j++) {
                    if (s1[j].equals(words.get(i))) {
                        count++;
                    }
                }
            }
            if (count == 2){
                System.out.println(s);
            }
        }
        reader1.close();
    }
}
