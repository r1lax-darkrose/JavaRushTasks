package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();
        Cat cat = new Cat("a");
        Cat cat1 = new Cat("b");
        Cat cat2 = new Cat("a");
        Cat cat3 = new Cat("b");
        Cat cat4 = new Cat("a");
        Cat cat5 = new Cat("b");
        Cat cat6 = new Cat("a");
        Cat cat7 = new Cat("b");
        Cat cat8 = new Cat("a");
        Cat cat9 = new Cat("b");
        map.put("Миша",cat);
        map.put("Ayan",cat1);
        map.put("Миш",cat2);
        map.put("Aya",cat3);
        map.put("Ми",cat4);
        map.put("Ay",cat5);
        map.put("М",cat6);
        map.put("A",cat7);
        map.put("Миша1",cat8);
        map.put("Ayan1",cat9);
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<>(map.values());

        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
