package org.phoneservice.mvpjetpack

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.phoneservice.mvpjetpack.bean.Goods
import org.phoneservice.mvpjetpack.iview.IGoodView
import org.phoneservice.mvpjetpack.presenter.GoodsPresenter
import java.lang.StringBuilder

class MainActivity : BaseActivity<IGoodView, GoodsPresenter<IGoodView>>(), View.OnClickListener,
    IGoodView {

    lateinit var tv1: TextView
    lateinit var btn1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        initView()
        initListener()
    }


    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tv1 = findViewById(R.id.tv1)
        btn1 = findViewById(R.id.btn1)
    }

    override fun initListener() {
        btn1.setOnClickListener(this)
    }

    override fun initData() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn1 -> mPresenter?.doGetAllGoods("xxx")
        }
    }

    override fun showAllGoods(goodsList: ArrayList<Goods>) {
        val sb = StringBuilder(goodsList.size)
        goodsList.forEach {
            sb.append(it.name)
        }
        tv1.text = sb
    }

    override fun initPresenter(): GoodsPresenter<IGoodView> {
        return GoodsPresenter()
    }


}
