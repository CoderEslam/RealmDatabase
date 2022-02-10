package com.doubleclick.realmdatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class TaskDB extends RealmObject {

    public TaskDB(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public TaskDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @PrimaryKey
    private int id;
    private String task;


}
