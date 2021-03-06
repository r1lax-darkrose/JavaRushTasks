package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;

        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            /*if (children != null) {
                for (Person a : children) {
                    out.writeObject(a);
                }
            }*/
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            /*Object obj;
            while ((obj = in.readObject()) != null) {
                children.add((Person)obj);
            }*/
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person ottis = new Person("Ottis", "Mellborn", 16);
        ottis.setFather(new Person("BOb", "Mellborn", 39));
        ottis.setMother(new Person("Judy", "Mellborn", 37));
        ottis.setChildren(null);
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("D:/My garbage/Initial.txt"));
        stream.writeObject(ottis);
        stream.close();

        Person cloneOttis;
        ObjectInputStream stream1 = new ObjectInputStream(new FileInputStream("D:/My garbage/Initial.txt"));
        cloneOttis = (Person)stream1.readObject();
        stream1.close();
        System.out.println(cloneOttis);
    }
}
