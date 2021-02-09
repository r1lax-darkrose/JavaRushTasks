package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:/My garbage/partOfPuzzle.part5.txt
        ArrayList<String> listOfPaths = new ArrayList<>();
        String filePath;
        while (!(filePath = reader.readLine()).equals("end")){
            for (int i = 0; i < 38; i++) {
                if (filePath.contains(String.valueOf(i))) {
                    listOfPaths.add(i, filePath);
                }
            }
        }

        FileOutputStream file = new FileOutputStream("D:/My garbage/partOfPuzzle.txt");
        FileInputStream file1;

        /*for (int i = 0; i < listOfPaths.size(); i++){
            if (!listOfPaths.get(i).endsWith(".part%d.txt")){
                file = new FileOutputStream(listOfPaths.get(i));
                listOfPaths.remove(i);
                break;
            }
        }*/

        for (int i = 0; i < listOfPaths.size(); i++){
            for (int j = 0; j < listOfPaths.size(); j++){
                if (i <= 9){
                    int last = listOfPaths.get(i).length()-5;
                    if (i == Integer.parseInt(listOfPaths.get(j).substring(last, last + 1))){
                        file1 = new FileInputStream(listOfPaths.get(j));
                        BufferedInputStream buffer = new BufferedInputStream(file1);
                        int num;
                        while((num = buffer.read()) != -1){
                            file.write(num);
                        }
                    }
                } else if (i > 9 && i <= 99){
                    int last = listOfPaths.get(i).length()-6;
                    if (i == Integer.parseInt(listOfPaths.get(j).substring(last, last + 2))){
                        file1 = new FileInputStream(listOfPaths.get(j));
                        BufferedInputStream buffer = new BufferedInputStream(file1);
                        int num;
                        while((num = buffer.read()) != -1){
                            file.write(num);
                        }
                    }
                }
            }

        }



    }
}
