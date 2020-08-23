package org.phoneservice.mvpjetpack.bean

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
data class Goods(var name: String,var content:String,var pic:Int) {
    constructor(name: String):this(name,"",0)
}