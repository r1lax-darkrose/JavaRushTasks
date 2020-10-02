package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] d = reader.readLine().split("-");
        Date date = new Date(Integer.parseInt(d[0]) - 1900, Integer.parseInt(d[1])-1, Integer.parseInt(d[2]));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, y", Locale.ENGLISH);
        System.out.println(simpleDateFormat.format(date).toUpperCase());
    }
}
