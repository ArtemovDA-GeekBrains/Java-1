package ru.geekbrains.java_one.lesson_5;

public class Main {

    public static void main(String[] args) {

        // Задание 1
        Cat c = new Cat("Barsik", 200.0f, 2.0f, 0.0f);
        Dog d = new Dog("Tuzik", 500.0f, 0.5f,10.0f);
        Bird b =  new Bird("Polly", 5.0f, 0.2f, 0.0f);
        Horse h = new Horse("Mustang", 1500.0f, 3.0f, 100.0f);

        // Задание 2 - 5
        Animal[] zoo = {c, d, b, h};

        float valRun = 200.0f;
        float valJump = 2.0f;
        float valSwim = 20.0f;

        for (int i = 0; i < zoo.length; i++) {

            String strName = "";
            String eventName = "";
            String eventRes = "";

            strName = zoo[i].getType() + " " + zoo[i].getName() + " can ";

            //Run
            eventName = String.format("run max %.2fm. tries to run ", zoo[i].getMaxRun());

            int resRun = zoo[i].run(valRun);
            if (resRun == Animal.SUCCESS) {
                eventRes = "success";
            } else if (resRun == Animal.ERROR) {
                eventRes = "error";
            }

            System.out.println(strName + eventName + valRun + " and " + eventRes);

            //Jump
            eventName = String.format("jump max %.2fm. tries to jump ", zoo[i].getMaxJump());

            int resJump = zoo[i].jump(valJump);
            if (resJump == Animal.SUCCESS) {
                eventRes = "success";
            } else if (resJump == Animal.ERROR) {
                eventRes = "error";
            }

            System.out.println(strName + eventName + valJump + " and " + eventRes);

            //Swim
            eventName = String.format("swim max %.2fm. tries to swim ", zoo[i].getMaxSwim());

            int resSwim = zoo[i].swim(valSwim);
            if (resSwim == Animal.SUCCESS) {
                eventRes = "success";
            } else if (resSwim == Animal.ERROR) {
                eventRes = "error";
            } else if (resSwim == Animal.CAN_NOT) {
                eventRes = "can not swim";
            }

            System.out.println(strName + eventName + valJump + " and " + eventRes);
        }
    }
}
