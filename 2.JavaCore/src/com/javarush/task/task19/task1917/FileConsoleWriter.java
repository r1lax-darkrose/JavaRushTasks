package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {
    }

    public FileConsoleWriter(String name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(String name, boolean bool) throws IOException {
        this.fileWriter = new FileWriter(name, bool);
    }
    public FileConsoleWriter(File name) throws IOException {
        this.fileWriter = new FileWriter(name);
    }
    public FileConsoleWriter(File name, boolean bool) throws IOException {
        this.fileWriter = new FileWriter(name, bool);
    }
    public FileConsoleWriter(FileDescriptor descriptor) throws IOException {
        this.fileWriter = new FileWriter(descriptor);
    }



    public void write(int c) throws IOException {
        System.out.print(c);
        fileWriter.write(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off+len;i++){
                System.out.print(cbuf[i]);
        }
        fileWriter.write(cbuf, off, len);
    }

    public void write(String str, int off, int len) throws IOException {
        System.out.print(str.substring(off, off+len));
        fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        System.out.print(cbuf);
        fileWriter.write(cbuf);
    }

    public void write(String str) throws IOException {
        System.out.print(str);
        fileWriter.write(str);
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
