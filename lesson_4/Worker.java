package ru.geekbrains.java_one.lesson_4;

// Задание 1.
public class Worker {

    private String surname;         //фамилия
    private float salary;           //зарплата
    private int age;                //возраст (в задании четко сказано - "поле возраст", а не "дата рождения")
    private String position;        //должность

    //Задание 8.
    private int ID;
    private static int index = 0;   //всё просто - сначала 0

    // Задание 2.

    public Worker(String surname, float salary, int age, String position) {
        this.surname = surname;
        this.salary = salary;
        this.age = age;
        this.position = position;
        this.ID = index++;          //инкремент в каждом новом конструкторе
    }

    // Задание 3.

    public String getSurname() {
        return this.surname;
    }

    public float getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public String getPosition() {
        return this.position;
    }

    public int getID() {
        return this.ID;
    }

    public String showFullInfo() {
        return (getSurname() + " " + getSalary() + " " + getAge() + " " + getPosition());
    }

    // Задание 6.

    public void setSalary(float salary) { this.salary = salary; }
}