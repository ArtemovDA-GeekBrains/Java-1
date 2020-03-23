package ru.geekbrains.java_one.lesson_5;

public class Bird extends Animal {
    Bird(String name, float maxRun, float maxJump, float maxSwim) {
        super("Bird", name, maxRun, maxJump, maxSwim);
    }

    @Override
    protected int swim(float lenSwim) {
        return CAN_NOT;
    }
}
