package com.alie.lifecycle

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

abstract class BasePresenter<V : BaseView>(var iView:V?) : DefaultLifecycleObserver {



    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        println("===LifeCycle===OnCreate Presenter")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        println("===LifeCycle===onResume Presenter")
    }


    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)

        println("===LifeCycle===onDestroy Presenter")
        iView = null
        onDestroy()
    }

    protected abstract fun onDestroy()

}