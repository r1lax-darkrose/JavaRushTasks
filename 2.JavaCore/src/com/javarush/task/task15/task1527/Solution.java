package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();//http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
        String[] words = s.split("\\?|&");


        for (int i = 0; i < words.length; i++) {
            if (words[i].contains("/")){
                continue;
            }
            if (words[i].contains("=")) {
                System.out.print((words[i].substring(0, words[i].indexOf("="))) + " ");
            }else
                System.out.print((words[i]) + " ");
        }
        System.out.println();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains("/")){
                continue;
            }
            if (words[i].contains("obj")) {
                try {
                        alert(Double.parseDouble(words[i].substring(words[i].indexOf("o") + 4)));
                }catch (Exception e){
                    alert(words[i].substring(words[i].indexOf("o") + 4));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
