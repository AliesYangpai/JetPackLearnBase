package org.phoneservice.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer

/**
 * 本案例主要演示LifeCycle的简单实现，使用一个时间计数器
 */
class MainActivity : AppCompatActivity() {
    lateinit var chronometer: MyChronometer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer = findViewById(R.id.chronometer)
        lifecycle.addObserver(chronometer)
//        var time = System.currentTimeMillis()// unix时间 从1970-1-1 --到现在的毫秒数 然而不同的时区，返回结果不同
//        mTime = SystemClock.elapsedRealtime()  // 代表手机系统从上次启动到现在所经过的毫秒数 （用这个来做时间段的统计比价合理）

    }

}
