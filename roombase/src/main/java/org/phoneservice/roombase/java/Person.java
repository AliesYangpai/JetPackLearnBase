package org.phoneservice.roombase.java;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Entity //代表此类会映射到SQLite数据库中
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "person_name")
    private String name;
    @ColumnInfo(name = "person_age")
    private int age;
    @ColumnInfo(name = "person_hobby")
    private String hobby;
    @ColumnInfo(name = "person_isVip")
    private boolean isVip;
    Person() {
    }


    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}

