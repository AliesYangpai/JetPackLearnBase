package org.phoneservice.mvpjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.phoneservice.mvpjetpack.presenter.BasePresenter

abstract class BaseActivity<V : IBaseView, P : BasePresenter<V>> : AppCompatActivity(),IBaseView{

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = initPresenter()
        mPresenter?.attachView(this as V)
        setContentView(layoutResource())
        initView()
        initListener()
        initData()
    }

    override fun onDestroy() {
        mPresenter?.detachView()
        super.onDestroy()
    }

    abstract fun initPresenter(): P
    abstract fun layoutResource(): Int
    abstract fun initView()
    abstract fun initListener()
    abstract fun initData()

    override fun showLoading() {
        // todo 进行加载框的实现 ( 放在baseActivity中好一些)
    }

    override fun stopLoading() {
        // todo 进行加载框停止加载时间 ( 放在baseActivity中好一些)
    }

    override fun showToast(msg:String) {
        // todo Toast的实现 ( 放在baseActivity中好一些)
    }
}
