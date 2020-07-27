package org.phoneservice.roombase.java;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Database(entities = {Person.class}, version = 3, exportSchema = false)
public abstract class PersonDataBase extends RoomDatabase {


    private volatile static PersonDataBase mInstance;

    public static PersonDataBase getDbInstance(Context context) {
        if (mInstance == null) {
            synchronized (PersonDataBase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(), PersonDataBase.class, "PersonDataBase")
                            .allowMainThreadQueries() // 不建调用此方法，这里仅用于测试使用
//                            .fallbackToDestructiveMigration() // 数据库版本升级后，直接舍弃原有数据
                            .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                            .build();
                }
            }
        }
        return mInstance;
    }

    public abstract PersonDao getPersonDao();

    private static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE person ADD COLUMN person_hobby TEXT");
        }
    };

    private static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("AlTER TABLE person ADD COLUMN person_isVip INTEGER NOT NULL DEFAULT 1");
        }
    };

}
