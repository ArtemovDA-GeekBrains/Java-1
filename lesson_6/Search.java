package ru.geekbrains.java_one.lesson_6;

// Задание 3
// Написать программу, которая проверяет присутствует ли указанное
// пользователем слово в файле.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Search {

    public static int searchWordInFile(String fileName, String word) {
        int res = 0;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int symbol = 0;
            int index = 0;
            byte[] wordBytes = word.getBytes();
            do {
                symbol = fis.read();
                if (wordBytes[index] == symbol) {
                    index++;
                    if (index == wordBytes.length) {
                        res = 1;
                        break;
                    }
                } else {
                    index = 0;
                }
            } while (symbol != -1);

        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println("Search word in file");

        int searchRes = searchWordInFile("exampleFile.txt","art");
        if (searchRes == 1) {
            System.out.println("Слово найдено!");
        } else if (searchRes == 0) {
            System.out.println("Слово не найдено!");
        }
    }
}
