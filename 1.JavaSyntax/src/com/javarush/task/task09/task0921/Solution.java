package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        try {
            for (int i = 0; i < 100; i++){
                list.add(i, scanner.nextInt());
            }
        }
        catch (Exception e){
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
        }

    }
}
