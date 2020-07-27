package org.phoneservice.roombase.java;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Database(entities = {Person.class},version = 1,exportSchema = false)
public abstract class PersonDataBase extends RoomDatabase {
    public abstract PersonDao getPersonDao();
}
