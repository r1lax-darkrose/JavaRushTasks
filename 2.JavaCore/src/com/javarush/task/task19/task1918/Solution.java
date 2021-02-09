package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:/My garbage/Initial.txt
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String s, fullString = "";
        while ((s = fileReader.readLine()) != null){
            fullString += s;
        }
        fileReader.close();
        /*    System.out.println(fullString);
            Pattern pattern = Pattern.compile("(<.+?>)(.*?)(</.+?>)");
            Matcher matcher = pattern.matcher(fullString);
            while (matcher.find()){
                System.out.println(matcher.group());
            }*/
            Document doc = Jsoup.parse(fullString, "", Parser.xmlParser());
            Elements element = doc.select(args[0]);
            for (Element e : element) {
                System.out.println(e);
            }

    }
}
