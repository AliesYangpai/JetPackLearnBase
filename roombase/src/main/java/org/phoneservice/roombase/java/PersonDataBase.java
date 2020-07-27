package org.phoneservice.roombase.java;

import android.content.Context;

import androidx.core.app.NavUtils;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class PersonDataBase extends RoomDatabase {


    private volatile static PersonDataBase mInstance;

    public static PersonDataBase getDbInstance(Context context) {
        if (mInstance == null) {
            synchronized (PersonDataBase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(), PersonDataBase.class, "PersonDataBase")
                            .allowMainThreadQueries() // 不建调用此方法，这里仅用于测试使用
                            .build();
                }
            }
        }
        return mInstance;
    }

    public abstract PersonDao getPersonDao();
}
