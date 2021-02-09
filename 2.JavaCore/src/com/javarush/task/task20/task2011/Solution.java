package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String)in.readObject();
            year = in.readInt();
        }

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apt = new Apartment("asd", 2017);
        ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("D:/My garbage/Initial.txt"));
        ou.writeObject(apt);
        ou.close();
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("D:/My garbage/Initial.txt"));
        Apartment reApt = (Apartment) oi.readObject();
        System.out.println(reApt.toString());
        oi.close();
    }
}
