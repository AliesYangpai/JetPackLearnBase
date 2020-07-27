package org.phoneservice.roombase.java;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Dao   //Dao is short for Database access object:用于数据库对象访问的
public interface PersonDao {
    @Insert
    void insertPerson(Person... p);

    @Delete
    int deletePerson(Person... p);

    @Update
    int updatePerson(Person... p);

    @Query(value = "delete from person")
    int deleteAllPerson();

    @Query(value = "select * from person order by id desc")
//    List<Person> getAllPerson();
    LiveData<List<Person>> getAllPerson();

}
