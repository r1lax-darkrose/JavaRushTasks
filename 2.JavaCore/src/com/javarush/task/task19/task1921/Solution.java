package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = reader.readLine()) != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("d M y");
            Date date;
            String[] splitLine = line.split(" ");
            if (splitLine.length == 4){
                date = dateFormat.parse(splitLine[1] + " " +splitLine[2] + " " + splitLine[3]);
                PEOPLE.add(new Person(splitLine[0], date));
            }else if (splitLine.length == 6){
                date = dateFormat.parse(splitLine[3] + " " + splitLine[4] + " " + splitLine[5]);
                PEOPLE.add(new Person(splitLine[0] + " " + splitLine[1] + " " + splitLine[2], date));
            }
        }
        reader.close();
        /*for (int i = 0; i < PEOPLE.size(); i++){
            System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthDate());
        }*/
    }
}
