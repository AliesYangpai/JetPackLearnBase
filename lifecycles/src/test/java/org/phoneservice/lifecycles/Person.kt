package org.phoneservice.lifecycles

/**
 * Created by Administrator on 2020/7/26 0026.
 * 类描述  构造函数专题：
 * 版本
 */


/**
 * 主构函数=====================================================开始
 */
/**
 * 写法1：
 */
//class Person(name: String, age: Int) {
//}
/**
 * 写法2：target
 */
//class Person(name: String, age: Int) {
//    var name: String = ""
//    var age: Int = 0
//    init {
//        this.name = name
//        this.age = age
//    }
//}
/**
 * 写法3：target
 */
//class Person(var name: String, var age: Int) {
//}
/**
 * 主构函数=====================================================结束
 */


/**
 * 次构函数=====================================================开始
 */
class Person(var name: String, var age: Int) {
    var number: String = ""

    constructor(name: String, age: Int, number: String) : this(name, age) {
        this.number = number
    }
}

