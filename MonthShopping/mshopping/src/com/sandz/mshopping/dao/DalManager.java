package com.sandz.mshopping.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by mzain on 5/5/14.
 */
public class DalManager {

    private static DalManager instance = null;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLiteDatabase db;

    private DaoMaster.DevOpenHelper helper;
    //private UpgradeHelper helper;

    private DalManager() {
        // Exists only to defeat instantiation.
    }

    public static DalManager getInstance(Context context) {
        if(instance == null) {
            instance = new DalManager();

            instance.helper = new DaoMaster.DevOpenHelper(context, "mshopping.sqlite", null);
            //instance.helper = new UpgradeHelper(context, "Conferencia_DB.sqlite", null);
            instance.db = instance.helper.getWritableDatabase();
            instance.daoMaster = new DaoMaster(instance.db);
            instance.daoSession = instance.daoMaster.newSession();
        }
        return instance;
    }

    public DaoSession getDaoSession(){
        return this.daoSession;
    }
}
