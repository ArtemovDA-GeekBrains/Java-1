package ru.geekbrains.java_one.lesson_6;

// Задание 1
// Создать 2 текстовых файла, примерно по 50-100 символов в каждом
// (особого значения не имеет);

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Create {

    static final int LENGTH_FILE = 100;

    static String alphabet = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    static Random rand = new Random();

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

        System.out.println("Create files");

        createFile("file1.txt", createString(LENGTH_FILE));
        createFile("file2.txt", createString(LENGTH_FILE));

    }
}
