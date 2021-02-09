package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));//D:/My garbage/Initial.txt
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));//D:/My garbage/Final.txt
        reader.close();
        List<String> fileList1 = new ArrayList<>();
        List<String> fileList2 = new ArrayList<>();
        String s, s1;
        while ((s = file1.readLine()) != null){
            fileList1.add(s);
        }
        while ((s1 = file2.readLine()) != null){
            fileList2.add(s1);
        }
        file1.close();
        file2.close();

        int num = 0;
        try {
            for (int i = 0; i < fileList1.size();) {
                if (num%2 == 0) {
                    if (fileList1.get(i).equals(fileList2.get(i))) {
                        lines.add(new LineItem(Type.SAME, fileList1.get(i)));
                        fileList1.remove(i);
                        fileList2.remove(i);
                    }
                    if (fileList1.get(i).equals(fileList2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, fileList2.get(i)));
                        lines.add(new LineItem(Type.SAME, fileList2.get(i + 1)));
                        fileList1.remove(i);
                        fileList2.remove(i);
                        fileList2.remove(i);
                    }
                    if (fileList1.get(i + 1).equals(fileList2.get(i))) {
                        lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                        lines.add(new LineItem(Type.SAME, fileList1.get(i + 1)));
                        fileList1.remove(i);
                        fileList1.remove(i);
                        fileList2.remove(i);
                    }
                    num++;
                }
                if (num%2 == 1) {
                    if (fileList1.get(i).equals(fileList2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, fileList2.get(i)));
                        lines.add(new LineItem(Type.SAME, fileList1.get(i)));
                        fileList1.remove(i);
                        fileList2.remove(i);
                        fileList2.remove(i);
                        num++;
                    }
                    if (fileList1.get(i + 1).equals(fileList2.get(i))) {
                        lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                        lines.add(new LineItem(Type.SAME, fileList2.get(i)));
                        fileList1.remove(i);
                        fileList1.remove(i);
                        fileList2.remove(i);
                        num++;
                    }
                    num++;
                }
            }
        }catch (Exception e){
            if (fileList1.size() > fileList2.size()){
                lines.add(new LineItem(Type.REMOVED, fileList1.get(0)));
            }else if (fileList1.size() < fileList2.size()){
                lines.add(new LineItem(Type.ADDED, fileList2.get(0)));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
