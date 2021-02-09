package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")){
            ReadThread thread = new ReadThread(fileName);
            thread.start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        public void run() {
            int currentMax = 0;
            int formOfByte = 0;
            try {
                for (int i = 0; i <= 127; i++){
                    FileInputStream file = new FileInputStream(fileName);
                    int max = 0;
                    while (file.available() > 0){
                        int num = file.read();
                        if (num == i){
                            max++;
                        }
                    }
                    if (max > currentMax){
                        currentMax = max;
                        formOfByte = i;
                    }
                    file.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            resultMap.put(fileName, formOfByte);
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
