package org.phoneservice.roombase.java;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述  使用一个仓来进行数据的获取
 * 版本
 */
class PersonRepository {

    private LiveData<List<Person>> listLiveData;
    private PersonDataBase dbInstance;
    private PersonDao personDao;

    PersonRepository(Context context) {
        dbInstance = PersonDataBase.getDbInstance(context);
        personDao = dbInstance.getPersonDao();
    }

    LiveData<List<Person>> getAllLiveData() {
        listLiveData = personDao.getAllPerson();
        return listLiveData;
    }

    void updatePersonData() {
        Person person = new Person("wangwu", 40,"写代码");
        person.setId(17);
        personDao.updatePerson(person);
    }

    void addPersonData() {
        Person person1 = new Person("张三", 10,"看书");
        Person person2 = new Person("李四", 20,"听音乐");
        Person person3 = new Person("王五", 30,"做家务");
        personDao.insertPerson(person1, person2, person3);
    }

    void deletePersonData() {
        Person person = new Person();
        person.setId(17);
        personDao.deletePerson(person);
    }


    void deleteAllPersonData() {
        int i = personDao.deleteAllPerson();
        Log.i("Main2Activity", "删除的行数：i:" + i);
    }

}
