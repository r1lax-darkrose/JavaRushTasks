package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        Date startyear = new Date();
        startyear.setHours(0);
        startyear.setTime(0);
        startyear.setMinutes(0);
        startyear.setMonth(0);
        startyear.setDate(0);
        startyear.setYear(date1.getYear());
        long numberdays = date1.getTime() - startyear.getTime();
        long mils = 60 * 60 * 24 * 1000;
        int count = (int)(numberdays / mils);
        System.out.println(count);
        if (count % 2 == 1)
            return true;
        else
            return false;
    }
}
