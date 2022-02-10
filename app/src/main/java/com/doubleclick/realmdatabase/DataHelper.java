package com.doubleclick.realmdatabase;

import io.realm.Realm;

public class DataHelper {

    public static void newTask(Realm realm, int taskId, String task) {
        realm.beginTransaction();
        TaskDB taskDB = realm.createObject(TaskDB.class, taskId);
        taskDB.setTask(task);
        realm.commitTransaction();

    }

    public static void deleteTask(Realm realm, long id) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TaskDB taskDB = realm.where(TaskDB.class).equalTo("id", id).findFirst();
                if (taskDB != null) {
                    taskDB.deleteFromRealm();
                }
            }
        });
    }
}
