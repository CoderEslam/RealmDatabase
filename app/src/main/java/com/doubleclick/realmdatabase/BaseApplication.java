package com.doubleclick.realmdatabase;

import android.app.Application;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//        Realm realm = Realm.getDefaultInstance();
        //  Insert method (1)
        /*realm.beginTransaction();
        RealmModel user = realm.createObject(RealmModel.class);
        user.setName("Eslam");
        user.setAge("25");
        realm.commitTransaction();*/
        //  Insert method (2)
        /*RealmModel realmModel = new RealmModel("EslamGhazy", "25");
        realm.beginTransaction();
        realm.copyToRealm(realmModel);
        realm.commitTransaction();*/

        //Multiple entries
        /*List<RealmModel> realmModelList = Arrays.asList(new RealmModel("Eslam", "23"),
                new RealmModel("Ghazy", "24"),
                new RealmModel("G", "5"));
        realm.beginTransaction();
        realm.insert(realmModelList);
        realm.commitTransaction();

        // Query looking at all users
        RealmQuery<RealmModel> realmQuery = realm.where(RealmModel.class);
        // Query conditions
        realmQuery.equalTo("name","Eslam");
        realmQuery.or().equalTo("name","Ghazy");
        // Execute the query
        RealmResults<RealmModel> realmResults = realmQuery.findAll();
        realmResults.get(0).getAge();

        // another  way
        // Query looking at all users
        realmQuery.greaterThan("age",23).findAll();*/



    }
}
