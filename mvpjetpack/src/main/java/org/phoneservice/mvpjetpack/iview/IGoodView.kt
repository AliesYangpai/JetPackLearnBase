package org.phoneservice.mvpjetpack.iview

import org.phoneservice.mvpjetpack.IBaseView
import org.phoneservice.mvpjetpack.bean.Goods

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
interface IGoodView : IBaseView {
    fun showAllGoods(goodsList:ArrayList<Goods>)
}