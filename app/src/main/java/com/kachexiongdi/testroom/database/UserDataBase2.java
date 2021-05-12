package com.kachexiongdi.testroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kachexiongdi.testroom.bean.ChildUser;
import com.kachexiongdi.testroom.bean.User;
import com.kachexiongdi.testroom.dao.ChildUserDao;
import com.kachexiongdi.testroom.dao.UserDao;

/**
 * author : qiukailong
 * date   : 2020/12/4  6:46 PM
 * desc   :
 */
@Database(entities = {ChildUser.class, User.class}, version = 2, exportSchema = false)
public abstract class UserDataBase2 extends RoomDatabase {
    public static final String DB_NAME = "CompanyDatabase.db";
    private static volatile UserDataBase2 instance;

    public static synchronized UserDataBase2 getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static UserDataBase2 create(final Context context) {
        return Room.databaseBuilder(
                context,
                UserDataBase2.class,
                DB_NAME)
//                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public abstract ChildUserDao getChildUserDao();

    public abstract UserDao getUserDao();
}