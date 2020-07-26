package org.phoneservice.lifecycles;

/**
 * Created by Administrator on 2020/7/26 0026.
 * 类描述
 * 版本
 */
public class PersonJava {
    private String name;
    private int age;
    private String number;

    public PersonJava(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonJava(String name, int age, String number) {
        this(name, age);
        this.number = number;
    }
}
