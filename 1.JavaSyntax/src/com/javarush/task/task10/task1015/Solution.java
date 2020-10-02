package com.javarush.task.task10.task1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() throws IOException {
        //напишите тут ваш код
        ArrayList<String>[] arrayLists = new ArrayList[3];
        arrayLists[0] = new ArrayList<>();
        arrayLists[1] = new ArrayList<>();
        arrayLists[2] = new ArrayList<>();
        arrayLists[0].add("a");
        arrayLists[1].add("b");
        arrayLists[2].add("c");
        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}