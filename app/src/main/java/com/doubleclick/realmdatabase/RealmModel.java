package com.doubleclick.realmdatabase;

import io.realm.RealmObject;

public class RealmModel extends RealmObject {

    public RealmModel() {
    }

    public RealmModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String name;
    private String age;
}
