package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

import static com.javarush.task.task20.task2020.Solution.Sex.FEMALE;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
         transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
         transient PrintStream outputStream;
         transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        /*@Override
        public String toString() {
            return "firstname: " + firstName + "\n" +
                    "lastname: " + lastName + "\n" +
                    "fullname: " + fullName + "\n" +
                    "greeting: " + greeting + "\n" +
                    "country: " + country + "\n" +
                    "sex: " + sex + "\n" +
                    "outputstream: " + outputStream + "\n" +
                    "logger: " + logger;
        }*/
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/My garbage/Initial.txt"));
        Person person = new Person("Igor", "Pigor", "Volgograd", Sex.MALE);
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/My garbage/Initial.txt"));
        Person person1 = (Person) ois.readObject();
        System.out.println(person1);*/
    }
}
