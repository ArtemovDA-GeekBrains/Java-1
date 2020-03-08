package ru.geekbrains.java_one.lesson_2;

import java.util.Arrays;

public class Main {

    // 1
    // Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    private static void replaceElements(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
    }

    // 2
    // Задать пустой целочисленный массив размером 8.
    // Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    public static void fillValues(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = 1 + 3 * i;
        }
    }

    // 3
    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
    // принимающий на вход массив и умножающий числа меньше 6 на 2;
    public static void mulElements(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    // 4
    // Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    public static void findMin(int[] arr) {

        int valMin = arr[0];
        int indMin = 0;

        for (int i = 0; i <arr.length; i++) {
            if (arr[i] < valMin) {
                valMin = arr[i];
                indMin = i;
            }
        }

        System.out.println("Минимальный элемент находится в массиве под индексом "
                + indMin + " со значением  = " + valMin);
    }

    public static void findMax(int[] arr) {

        int valMax = arr[0];
        int indMax = 0;

        for (int i = 0; i <arr.length; i++) {
            if (arr[i] > valMax) {
                valMax = arr[i];
                indMax = i;
            }
        }

        System.out.println("Максимальный элемент находится в массиве под индексом "
                + indMax + " со значением  = " + valMax);
    }

    // 5 *
    // Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    // заполнить его диагональные элементы единицами, используя цикл(ы);
    public static void fillDiagonal(int[][] arr) {

        for(int i = 0, j = arr.length - 1; i < arr.length; i++, --j) {
            arr[i][i] = 1;
            arr[i][j] = 1;
        }
    }

    // 6 **
    // Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место,
    // в котором сумма левой и правой части массива равны.
    // Примеры:
    // checkBalance([1, 1, 1, || 2, 1]) → true,
    // checkBalance ([2, 1, 1, 2, 1]) → false,
    // checkBalance ([10, || 1, 2, 3, 4]) → true.
    // Абстрактная граница показана символами ||, эти символы в массив не входят.
    private static boolean checkBalance(int[] arr) {
        int lSum, rSum;

        for (int i = 0; i < arr.length + 1; i++) {
            lSum = 0;
            rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                rSum += arr[j];
            }

            if (lSum == rSum) return true;
        }
        return false;
    }

    // 7 ***
    // Написать метод, которому на вход подаётся одномерный массив и
    // число n (может быть положительным, или отрицательным), при этом
    // метод должен циклически сместить все элементы массива на n позиций.

    // 8 ****
    // Не пользоваться вспомогательным массивом при решении задачи 7.
    private static void shiftOfNumbers(int[] arr, int n) {
        //маcсив до сдвига
        //for (int i : arr) System.out.print(i + " ");
        //System.out.println();

        if (n > 0) {
            for (int x = 0; x < n; x++) {
                int buf = arr[arr.length - 1];
                if (arr.length - 1 >= 0) System.arraycopy(arr, 0, arr, 1, arr.length - 1);
                arr[0] = buf;
                //маcсив после очередного сдвига
                //for (int i : arr) System.out.print(i + " ");
                //System.out.println();
            }
        }
        if (n < 0) {
            for (int x = 0; x > n; x--) {
                int buf = arr[0];
                System.arraycopy(arr, 1, arr, 0, arr.length - 1);
                arr[arr.length - 1] = buf;
                //маcсив после очередного сдвига
                //for (int i : arr) System.out.print(i + " ");
                //System.out.print();
            }
        }
    }


    public static void debug_print_arr(String text, int[] arr) {

        System.out.println(text);

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void debug_print_matrix(String text, int[][] arr) {

        System.out.println(text);

        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Задание 1:");
        int[] arr1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив " + Arrays.toString(arr1));
        replaceElements(arr1);
        System.out.println("Результирующий массив " + Arrays.toString(arr1));

        System.out.println("----------------------------------------");

        System.out.println("Задание 2:");
        int[] arr2 = new int[8];
        System.out.println("Исходный массив " + Arrays.toString(arr2));
        fillValues(arr2);
        System.out.println("Результирующий массив " + Arrays.toString(arr2));

        System.out.println("----------------------------------------");

        System.out.println("Задание 3:");
        int[] arr3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив " + Arrays.toString(arr3));
        mulElements(arr3);
        System.out.println("Результирующий массив " + Arrays.toString(arr3));

        System.out.println("----------------------------------------");

        System.out.println("Задание 4:");
        int[] arr4 = new int[]{1, -3, 10, 2, -12, 4, 22, 0, 4, 8, -5, 1};
        System.out.println("Исходный массив " + Arrays.toString(arr4));
        findMin(arr4);
        findMax(arr4);

        System.out.println("----------------------------------------");

        System.out.println("Задание 5:");
        int[][] arr5 = new int[10][10];
        debug_print_matrix("Исходный массив ", arr5);
        fillDiagonal(arr5);
        debug_print_matrix("Результирующий массив ", arr5);

        System.out.println("----------------------------------------");

        System.out.println("Задание 6:");
        int[] arr6_1 = new int[]{1, 1, 1, 2, 1};
        int[] arr6_2 = new int[]{2, 1, 1, 2, 1};
        int[] arr6_3 = new int[]{10, 1, 2, 3, 4};
        System.out.println("Результат = " + checkBalance(arr6_1));
        System.out.println("Результат = " + checkBalance(arr6_2));
        System.out.println("Результат = " + checkBalance(arr6_3));

        System.out.println("----------------------------------------");

        System.out.println("Задание 8:");
        int[] arr8_1 = new int[]{1, 5, -2, 7, 0, -6, 3, 2};

        System.out.println("Исходный массив " + Arrays.toString(arr8_1));

        System.out.println("Cдвиг +2");
        shiftOfNumbers(arr8_1, 2);
        System.out.println("Результирующий массив " + Arrays.toString(arr8_1));

        System.out.println();

        int[] arr8_2 = new int[]{1, 5, -2, 7, 0, -6, 3, 2};
        System.out.println("Исходный массив " + Arrays.toString(arr8_2));

        System.out.println("Cдвиг -2");
        shiftOfNumbers(arr8_2, -2);
        System.out.println("Результирующий массив " + Arrays.toString(arr8_2));

        System.out.println("----------------------------------------");
    }
}
