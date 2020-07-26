package org.phoneservice.lifecycles

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/**
 * Created by Administrator on 2020/7/26 0026.
 * 类描述
 * 版本
 */
class MyChronometer(context: Context, attributeSet: AttributeSet?) :
    Chronometer(context, attributeSet), LifecycleObserver {

    var time: Long = 0
    private var mContext: Context? = null

    init {
        mContext = context
    }

    constructor(context: Context) : this(context, null)

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun doStopTime() {
        time = SystemClock.elapsedRealtime() - this.base
        this.stop()
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun doResumeTime() {
        val timeBase = SystemClock.elapsedRealtime() - time
        this.base = timeBase
        this.start()
    }

}