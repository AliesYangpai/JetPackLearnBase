package org.phoneservice.mvpjetpack.model

import org.phoneservice.mvpjetpack.bean.Goods

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
interface IGoodModel {
    fun getAllGoods(url: String, onDataBackListener: OnDataBackListener)
    interface OnDataBackListener {
        fun onDataBackSuccess(goodsList: ArrayList<Goods>)
        fun onDataBackError(code: Int, msg: String)
    }
}