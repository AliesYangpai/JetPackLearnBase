package org.phoneservice.mvpjetpack.presenter

import org.phoneservice.mvpjetpack.IBaseView
import java.lang.ref.WeakReference

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
abstract class BasePresenter<V : IBaseView> {

    private var weakReference: WeakReference<V>? = null
    protected var iView: V? = null

    fun attachView(view: V) {
        weakReference = WeakReference(view)
        iView = weakReference?.get()
    }

    fun detachView() {
        weakReference?.clear()
        weakReference = null
    }
}