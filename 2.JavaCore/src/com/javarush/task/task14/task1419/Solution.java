package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int[] array = new int[10];
                System.out.println(array[11]);

        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            File file = new File("asd");
            InputStream inputStream = new FileInputStream(file);
            inputStream.read();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer.parseInt("asd");
        }catch (Exception e){
            exceptions.add(e);
            exceptions.add(new NullPointerException());
            exceptions.add(new IndexOutOfBoundsException());
            exceptions.add(new StringIndexOutOfBoundsException());
            exceptions.add(new ClassCastException());
            exceptions.add(new NegativeArraySizeException());
            exceptions.add(new ArrayStoreException());
        }



    }

}
