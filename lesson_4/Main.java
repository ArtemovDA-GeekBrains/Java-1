package ru.geekbrains.java_one.lesson_4;

// 1. Создать класс "Сотрудник" с полями: Фамилия, зарплата, возраст, должность;
// 2. Конструктор класса должен заполнять эти поля при создании объекта;
// 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
// 4. Вывести при помощи методов из пункта 3 ФИО и должность.
// 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
// 6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
// 7 * Подсчитать средние арифметические зарплаты и возраста сотрудников из п.5
// 8 *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный
//       уникальный идентификационный порядковый номер

import ru.geekbrains.java_one.lesson_4.Worker;

public class Main {

    // Задание 6.
    public static void increaser(Worker[] list, byte age, float increment) {
        for (int i=0; i<list.length; i++) {
            if (list[i].getAge() > age) {
                list[i].setSalary(increment);
            }
        }
    }

    // Задание 7.

    // Средний возраст
    public static float getAverageAge(Worker[] list){
        float tmp = 0.0f;

        for (Worker worker : list) tmp += worker.getAge();

        return tmp/list.length;
    }

    // Средняя ЗП
    public static float getAverageSalary(Worker[] list){
        float tmp = 0.0f;

        for (Worker worker : list) tmp += worker.getSalary();

        return tmp/list.length;
    }

    public static void main(String[] args) {
        Worker tmpWorker = new Worker("Иванов", 80000, 35, "Developer");

        // Задание 4.

        System.out.println("Сотрудник " + tmpWorker.getSurname() + " на должности " + tmpWorker.getPosition());
        System.out.println("----------------------------------------");

        // Задание 5.
        // Создать массив из 5 сотрудников.
        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

        Worker[] arr = new Worker[] {
            new Worker("Блок", 80000, 35, "Middle Developer"),
            new Worker("Маяковский", 100000, 42, "Senior Developer"),
            new Worker("Есенин", 60000, 25, "Junior Developer"),
            new Worker("Хармс", 120000, 44, "Team Leader"),
            new Worker("Гумилев", 110000, 46, "Technical Leader")
        };

        for(int i=0; i<arr.length; i++) {
            if (arr[i].getAge() > 40) {
                System.out.println(arr[i].showFullInfo());
            }
        }
        System.out.println("----------------------------------------");

        // Проверка задания 6.
        increaser(arr, (byte) 45, 5000.0f);
        System.out.println("----------------------------------------");

        // Проверка задания 7.
        System.out.println("Средний возраст = " + getAverageAge(arr));
        System.out.println("Средняя зарплата = " + getAverageSalary(arr));
        System.out.println("----------------------------------------");

        // Проверка задания 8.
        for (Worker worker : arr) {
            System.out.println(worker.getID());
        }
    }
}
