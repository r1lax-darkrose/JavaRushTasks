package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0){
            return;
        }
        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
        String s = filePath.readLine();
        PrintStream file = new PrintStream(new FileOutputStream(s, true));//"D:/My garbage/Final.txt"
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
        filePath.close();
        String line;
        int id = 0;
        while ((line = reader.readLine()) != null){
            String[] strings = line.split(" ");
            if (Integer.parseInt(strings[0]) > id){
                id = Integer.parseInt(strings[0]);
            }
        }
        reader.close();
        if (args[0].equals("-c")){
            id++;

            file.printf("%-8d%-30.30s%-8.2f%-4d%n", id, args[1], Float.parseFloat(args[2]), Integer.parseInt(args[3]));
        }
        file.close();

    }
}
