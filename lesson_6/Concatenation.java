package ru.geekbrains.java_one.lesson_6;

// Задание 2
// Написать программу, «склеивающую» эти файлы, то есть в начале
// идет текст из первого файла, потом текст из второго.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Concatenation {

    static final int LENGTH_FILE = 100;

    static String alphabet = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    static Random rand = new Random();

    public static void concatFiles(String[] names, String distName) {
        try {
            FileOutputStream fos = new FileOutputStream(distName);
            for (String name: names) {
                FileInputStream fis = new FileInputStream(name);
                int i;
                do {
                    i = fis.read();
                    if (i != -1) {
                        fos.write(i);
                    }
                } while (i != -1);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static String createString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public static void createFile(String fileName, String text) {
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.write(text);
            pw.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Concatenation files");

        createFile("file1.txt", createString(LENGTH_FILE));
        createFile("file2.txt", createString(LENGTH_FILE));
        concatFiles(new String[] {"file1.txt","file2.txt"},"flie3.txt");

    }
}
