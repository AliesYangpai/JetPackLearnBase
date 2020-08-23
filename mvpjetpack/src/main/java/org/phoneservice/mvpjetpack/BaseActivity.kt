package org.phoneservice.mvpjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

abstract class BaseActivity<V : IBaseView, P : BasePresenter<V>> : AppCompatActivity(), IBaseView {

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = initPresenter()
        lifecycle.addObserver(mPresenter!!)
        /**
         * 注意，mPresenter?.attachView(this as V) 不能直接方法在BasePresenter的onCreate观察方法中
         * 经过代码运行，建立 lifecycle.addObserver(mPresenter!!)之后，只有UI周期调用后，才能响应到
         * 观察方法中，因此，为了避免重复调用 mPresenter?.attachView(this as V) 在此处调用即可
         */
        mPresenter?.attachView(this as V)
        Log.i("BasePresenter", "==========BaseActivity 中onCreate")
        setContentView(layoutResource())
        initView()
        initListener()
        initData()
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

    override fun showToast(msg: String) {
        // todo Toast的实现 ( 放在baseActivity中好一些)
    }
}
