package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c = 0;


        while (true) {
            String a = reader.readLine();
            try {
                c = Integer.parseInt(a);
                if (c > 0 && c < 128) {
                    short s = (short) c;
                    print(s);
                    continue;
                } else {

                    print(c);
                    continue;
                }

            } catch (Exception e) {
                try {
                    if (a.contains(".")) {
                        Double d = Double.parseDouble(a);
                        print(d);
                    } else if (a.equals("exit")) {
                        break;

                    } else {
                        print(a);
                    }
                } catch (Exception e1){
                    print(a);
                }
            }



        }

    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
