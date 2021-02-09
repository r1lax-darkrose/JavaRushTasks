package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1);
        testString.printSomething();
        String s = byteArrayOutputStream.toString();
        System.setOut(printStream);
        String[] strings = s.split(" ");
        int num1 = Integer.parseInt(strings[0]), num2 = Integer.parseInt(strings[2]);
        switch (strings[1]){
            case ("+"):
                System.out.printf("%d + %d = " + (num1 + num2), num1, num2);
                break;
            case ("-"):
                System.out.printf("%d - %d = " + (num1 - num2), num1, num2);
                break;
            case ("*"):
                System.out.printf("%d * %d = " + (num1 * num2), num1, num2);
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

