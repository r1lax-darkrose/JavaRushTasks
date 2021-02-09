package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(reader2.readLine())));//D:\My garbage\Initial.txt
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader3.readLine())));//D:\My garbage\Final.txt
        reader2.close();
        reader3.close();
        String line, line1;
        while ((line = reader.readLine()) != null){
            allLines.add(line);
        }
        while ((line1 = reader1.readLine()) != null){
            forRemoveLines.add(line1);
        }
        Solution m1 = new Solution();
        m1.joinData();
        reader.close();
        reader1.close();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            for (int i = 0; i < allLines.size(); i++){
                for (int j = 0; j < forRemoveLines.size(); j++){
                    if (allLines.get(i).equals(forRemoveLines.get(j))){
                        allLines.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
