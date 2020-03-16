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

import static ru.geekbrains.java_one.lesson_4.Worker.incSalary;

public class Main {

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

        // Задание 6.

        Worker.incSalary(arr);

        // Проверка задания 6.
        for (Worker value : arr) {
            System.out.println(value.getSalary());
        }
        System.out.println("----------------------------------------");

        // Задание 7.
        System.out.println("Средний возраст = " + Worker.getAverageAge(arr));
        System.out.println("Средняя зарплата = " + Worker.getAverageSalary(arr));
        System.out.println("----------------------------------------");

        // Задание 8.
        for (Worker worker : arr) {
            System.out.println(worker.getID());
        }
    }
}
