package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArray);
        System.setOut(printStream1);
        testString.printSomething();
        String s = byteArray.toString();
        System.setOut(printStream);
        System.out.println(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file = new FileOutputStream(reader.readLine());//"D:/My garbage/Final.txt"
        reader.close();
        file.write(s.getBytes());
        file.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

