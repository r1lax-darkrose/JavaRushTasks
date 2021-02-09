package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s1));
        while(true){
            String s = reader.readLine();
            if (s.equals("exit")){
                bufferedWriter.write(s);
                break;
            }
            bufferedWriter.write(s + "\n");
        }
        bufferedWriter.close();
        reader.close();
    }
}
