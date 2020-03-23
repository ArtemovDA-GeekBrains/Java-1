package ru.geekbrains.java_one.lesson_5;

public class Cat extends Animal {
    Cat(String name, float maxRun, float maxJump, float maxSwim) {
        super("Cat", name, maxRun, maxJump, maxSwim);
    }

    @Override
    protected int swim(float lenSwim) {
        return CAN_NOT;
    }
}
