package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true){
                String filePath = reader.readLine();
                try {
                    FileInputStream file = new FileInputStream(filePath);
                    file.close();
                }catch (FileNotFoundException e){
                    System.out.println(filePath);
                    reader.close();
                }
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}
