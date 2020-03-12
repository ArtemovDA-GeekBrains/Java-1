//Домашняя работа №3. Задание 2
//Переделать проверку победы, чтобы она не была реализована просто набором условий.

// Я использовал вместо старого метода два новых для определения победы:
// Метод "checkLine()" проверяет одну из линий (горизонталь, вертикаль, диагональ). Используется уравнение прямой из алгебры (y = kx + b).
// Метод "checkWin()" проверяет все линии, и если находит выигрышную, то возвращает "true", иначе "false".

package ru.geekbrains.java_one.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class les_3_task_2 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';

    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int size;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static void initField() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        size = fieldSizeX = fieldSizeY; //вводим переменную size - размерность поля игры (3*3, 4*4 и т.д)

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.println("------");
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода (от 1 до 3) через пробел (строка - столбец) >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[x][y] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = DOT_AI;
    }

    private static boolean isFieldFull() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    //проверяет одну линию (горизонталь, вертикаль, диагональ). Используется уравнение прямой из алгебры (y = kx+b).
    public static boolean checkLine(int start_x, int start_y, int dx, int dy, char dot_type) {
        for (int i = 0; i < size; i++) {
            if (field[start_x + i * dx][start_y + i * dy] != dot_type)
                return false;
        }
        return true;
    }

    //проверяет все линии, и если находит выигрышную, то возвращает "true", иначе "false".
    private static boolean checkWin(char dot_type) {
        for (int i = 0; i < size; i++) {
            // проверка по строкам
            if (checkLine(i, 0, 0, 1, dot_type)) return true;
            // проверяем по столбцам
            if (checkLine(0, i, 1, 0, dot_type)) return true;
        }
        // проверяем по диагоналям
        if (checkLine(0, 0, 1, 1, dot_type)) return true;
        if (checkLine(0, size - 1, 1, -1, dot_type)) return true;

        return false;
    }

    private static void playOneRound() {
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Выиграл игрок!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            playOneRound();
            System.out.println("Сыграть снова? (введите 'no' - для окончания, всё остальное - для продолжения)");
            if (SCANNER.next().equals("no"))
                break;
        }
    }
}
