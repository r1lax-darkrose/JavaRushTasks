package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName(){
            return "As";
        }

        public Pet getChild(){
            return this;
        }
    }

    public static class Cat extends Pet{

    }

    public static class Dog extends Pet{

    }

}
