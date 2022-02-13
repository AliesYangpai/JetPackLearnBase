package com.alie.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : BaseActivity<MainPresenter, MainView>(), MainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("===LifeCycle===OnCreate MainActivity")
    }

    override fun onResume() {
        super.onResume()
        println("===LifeCycle===onResume MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("===LifeCycle===onDestroy MainActivity")
    }
    override fun initView() {
    }

    override fun initPresenter() = MainPresenter(this)
    override fun initListener() {
    }
    override fun initData() {
    }
}