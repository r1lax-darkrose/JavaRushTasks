package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{
        //start here - начни тут
        switch (args[0]){
            case "-c":{
                synchronized (allPeople) {
                    for (int i = 1; i <= ((args.length - 1) - ((args.length - 1) % 3)); i += 3) {
                        String name = args[i];
                        if (args[i + 1].equals("м")) {
                            Date date = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[i + 2]);
                            allPeople.add(Person.createMale(name, date));
                        } else if (args[i + 1].equals("ж")) {
                            Date date = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[i + 2]);
                            allPeople.add(Person.createFemale(name, date));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            }
            case "-u":{
                synchronized (allPeople) {
                    for (int i = 1; i <= ((args.length - 1) - ((args.length - 1) % 4)); i += 4) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(args[i + 1]);
                        if (args[i + 2].equals("м")) {
                            allPeople.get(id).setSex(Sex.MALE);
                        } else if (args[i + 2].equals("ж")) {
                            allPeople.get(id).setSex(Sex.FEMALE);
                        }
                        Date date = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[i + 3]);
                        allPeople.get(id).setBirthDate(date);
                    }
                    break;
                }
            }
            case "-d":{
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 1; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                    break;
                }
            }
            case "-i":{
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 1; i++) {
                        int id = Integer.parseInt(args[i]);
                        if (allPeople.get(id).getSex().equals(Sex.MALE)) {
                            String date = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(allPeople.get(id).getBirthDate());
                            System.out.println(allPeople.get(id).getName() + " " + "м" + " " + date);
                        } else if (allPeople.get(id).getSex().equals(Sex.FEMALE)) {
                            String date = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(allPeople.get(id).getBirthDate());
                            System.out.println(allPeople.get(id).getName() + " " + "ж" + " " + date);
                        }
                    }
                    break;
                }
            }
        }
    }
}
