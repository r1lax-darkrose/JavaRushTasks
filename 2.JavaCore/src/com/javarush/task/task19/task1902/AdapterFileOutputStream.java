package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;
    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }

    public static void main(String[] args) {

    }


}

