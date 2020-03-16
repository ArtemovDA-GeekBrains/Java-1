package ru.geekbrains.java_one.lesson_4;

// Задание 1.
public class Worker {

    private String surname;         //фамилия
    private int salary;             //зарплата
    private int age;                //возраст (в задании четко сказано - "поле возраст", а не "дата рождения")
    private String position;        //должность

    //Задание 8.
    private int ID;
    private static int index = 0;   //всё просто - сначала 0

    // Задание 2.

    public Worker(String surname, int salary, int age, String position) {
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

    public int getSalary() {
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
        return (surname + " " + salary + " " + age + " " + position);
    }

    // Задание 6.

    public void setSalary(int salary) { this.salary = salary; }

    public static void incSalary(Worker[] workersList) {
        for (Worker worker : workersList) {
            if (worker.getAge() >= 45) {
                worker.setSalary(worker.getSalary() + 5000);
            }
        }
    }

    // Задание 7.

    // Средний возраст
    public static float getAverageAge(Worker[] workersList){
        float tmp = 0.0f;

        for (Worker worker : workersList) tmp += worker.getAge();

        return tmp/workersList.length;
    }

    // Средняя ЗП
    public static float getAverageSalary(Worker[] workersList){
        float tmp = 0.0f;

        for (Worker worker : workersList) tmp += worker.getSalary();

        return tmp/workersList.length;
    }
}