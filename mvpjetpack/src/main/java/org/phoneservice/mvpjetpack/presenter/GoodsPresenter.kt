package org.phoneservice.mvpjetpack.presenter

import org.phoneservice.mvpjetpack.bean.Goods
import org.phoneservice.mvpjetpack.iview.IGoodView
import org.phoneservice.mvpjetpack.model.IGoodModel
import org.phoneservice.mvpjetpack.model.IGoodModelImpl

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
class GoodsPresenter<V : IGoodView> : BasePresenter<V>() {
    private var iGoodModel: IGoodModel? = null

    init {
        iGoodModel = IGoodModelImpl()
    }

    fun doGetAllGoods(url: String) {
        iGoodModel?.getAllGoods(url, object : IGoodModel.OnDataBackListener {
            override fun onDataBackSuccess(goodsList: ArrayList<Goods>) {
               iView?.showAllGoods(goodsList)
            }

            override fun onDataBackError(code: Int, msg: String) {
            }

        })
    }


}