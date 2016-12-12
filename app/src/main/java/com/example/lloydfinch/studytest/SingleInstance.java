package com.example.lloydfinch.studytest;

/**
 * Created by LloydFinch on 12/12/2016.
 */

public class SingleInstance {

    private static SingleInstance instance;

    private SingleInstance() {

    }

    public static SingleInstance getInstance() {

        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }

        return instance;
    }

}
