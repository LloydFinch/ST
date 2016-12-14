package com.example.lloydfinch.studytest;

/**
 * Created by LloydFinch on 12/12/2016.
 */

public class SingleInstance {

    //成员私有化
    private static SingleInstance instance;

    //构造方法私有化使得只能通过getInstance()获取
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
