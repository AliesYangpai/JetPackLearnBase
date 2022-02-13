package com.alie.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P : BasePresenter<V>,V:BaseView> : AppCompatActivity() {

    private var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        presenter = initPresenter().apply {
            lifecycle.addObserver(this)
        }
        initListener()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }


    protected abstract fun initView()
    protected abstract fun initPresenter(): P
    protected abstract fun initListener()
    protected abstract fun initData();

}