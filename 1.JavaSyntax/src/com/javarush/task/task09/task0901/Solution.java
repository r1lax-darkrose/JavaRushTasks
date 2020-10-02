package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/



public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        //напишите тут ваш код
        StackTraceElement[] stack1 = Thread.currentThread().getStackTrace();
        return stack1;
    }

    public static StackTraceElement[] method2() {
        method3();
        //напишите тут ваш код
        StackTraceElement[] stack2 = Thread.currentThread().getStackTrace();
        return stack2;
    }

    public static StackTraceElement[] method3() {
        method4();
        //напишите тут ваш код
        StackTraceElement[] stack3 = Thread.currentThread().getStackTrace();
        return stack3;
    }

    public static StackTraceElement[] method4() {
        method5();
        //напишите тут ваш код
        StackTraceElement[] stack4 = Thread.currentThread().getStackTrace();
        return stack4;
    }

    public static StackTraceElement[] method5() {
        //напишите тут ваш код
        StackTraceElement[] stack5 = Thread.currentThread().getStackTrace();
        return stack5;
    }
}
