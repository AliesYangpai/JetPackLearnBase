package org.phoneservice.lifecycles.test

/**
 * Created by Administrator on 2020/7/26 0026.
 * 类描述  一个继承的测试
 * 版本
 */
open class Animal(var name: String, var age: Int) {
}


class Dog(var dogName: String, var dogAge: Int) : Animal(dogName, dogAge) {
    var food: String = ""
    constructor(dogName: String, dogAge: Int, food: String) : this(dogName, dogAge) {
        this.food = food
    }
}