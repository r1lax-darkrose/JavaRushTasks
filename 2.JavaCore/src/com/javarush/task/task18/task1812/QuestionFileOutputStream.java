package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream parametr;
    public QuestionFileOutputStream(AmigoOutputStream parametr){
        this.parametr = parametr;
    }

    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("Д")){
            parametr.close();
            reader.close();
        }
    }

    @Override
    public void flush() throws IOException {
        parametr.flush();
    }

    @Override
    public void write(int b) throws IOException {
        parametr.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        parametr.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        parametr.write(b, off, len);
    }
}

