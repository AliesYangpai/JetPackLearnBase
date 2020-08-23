package org.phoneservice.mvpjetpack

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
abstract class BasePresenter<V : IBaseView> : IBasePresenter {
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

    override fun onCreate(owner: LifecycleOwner) {
        Log.i("BasePresenter","====观察到Activity的onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.i("BasePresenter","====观察到Activity的onStart")
    }
    override fun onResume(owner: LifecycleOwner) {
        Log.i("BasePresenter","====观察到Activity的onStart")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.i("BasePresenter","====观察到Activity的onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.i("BasePresenter","====观察到Activity的onStop")
    }
    override fun onDestroy(owner: LifecycleOwner) {
        Log.i("BasePresenter","====观察到Activity的onDestroy")
        detachView()
        owner.lifecycle.removeObserver(this) // 这里去移除观察者
    }
}