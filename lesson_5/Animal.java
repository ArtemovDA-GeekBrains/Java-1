package ru.geekbrains.java_one.lesson_5;

import java.util.Random;

public abstract class Animal {

    static final int ERROR = 0;    //дистанция больше максимальной
    static final int SUCCESS = 1;  //успешно
    static final int CAN_NOT = -1; //не умеет

    private String type;
    private String name;
    private float maxRun;
    private float maxSwim;
    private float maxJump;
    private final Random rand = new Random();

    Animal(String type, String name, float maxRun, float maxJump, float maxSwim) {

        float runDiff = rand.nextFloat() * maxRun - (maxRun / 2);
        float jumpDiff = rand.nextFloat() * maxJump - (maxJump / 2);
        float swimDiff = rand.nextFloat() * maxSwim - (maxSwim / 2);

        this.type = type;
        this.name = name;
        this.maxRun = maxRun + runDiff;
        this.maxJump = maxJump + jumpDiff;
        this.maxSwim = maxSwim + swimDiff;
    }

    String getType() {
        return this.type;
    }

    String getName() {
        return this.name;
    }

    float getMaxRun() {
        return this.maxRun;
    }

    float getMaxSwim() {
        return this.maxSwim;
    }

    float getMaxJump() {
        return this.maxJump;
    }

    protected int run(float lenRun) {
        if (lenRun < maxRun) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    protected int swim(float lenSwim) {
        if (lenSwim < maxSwim) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    protected int jump(float lenJump) {
        if (lenJump < maxJump) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
