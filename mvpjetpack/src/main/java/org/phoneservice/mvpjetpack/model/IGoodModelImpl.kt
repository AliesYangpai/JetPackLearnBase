package org.phoneservice.mvpjetpack.model

import org.phoneservice.mvpjetpack.bean.Goods

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
class IGoodModelImpl :IGoodModel {
    override fun getAllGoods(url: String, onDataBackListener: IGoodModel.OnDataBackListener) {

        val list = ArrayList<Goods>()
        list.add(Goods("dong"))
        list.add(Goods("xi"))
        list.add(Goods("nan"))
        list.add(Goods("bei"))
        list.add(Goods("shang"))
        list.add(Goods("西瓜"))
        onDataBackListener.onDataBackSuccess(list)
    }

}