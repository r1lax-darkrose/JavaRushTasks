package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
            threads.add(new Threads());
            threads.add(new Threads1());
            threads.add(new Threads2());
            threads.add(new Threads3());
            threads.add(new Threads4());
    }

    public static void main(String[] args) {
    }

    public static class Threads extends Thread{
        public void run(){
            while (true){
            }
        }
    }

    public static class Threads1 extends Thread{
        public void run(){
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Threads2 extends Thread{
        public void run(){
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
            }
        }
    }

    public static class Threads3 extends Thread implements Message{
        boolean b = false;
        public void run(){
            while (!b){
            }
        }

        public void showWarning(){
            b = true;
        }
    }

    public static class Threads4 extends Thread{
        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int i = 0;
            String s;
            try {
                while (!(s = reader.readLine()).equals("N")){
                    i += Integer.parseInt(s);
                }
                System.out.println(i);
            }catch (IOException e){

            }
        }
    }
}