package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution(4);
        ObjectOutputStream saveObject = new ObjectOutputStream(new FileOutputStream("D:/My garbage/Initial.txt"));
        System.out.println(solution);
        saveObject.writeObject(solution);
        saveObject.close();

        Solution solution1 = new Solution(3);
        ObjectInputStream loadObject = new ObjectInputStream(new FileInputStream("D:/My garbage/Initial.txt"));
        System.out.println(solution1);
        solution1 = (Solution) loadObject.readObject();
        System.out.println(solution1);
    }


    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
