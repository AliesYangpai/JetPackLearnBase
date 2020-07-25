package org.phoneservice.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.phoneservice.databinding.databinding.ActivityMainBinding

/**
 * databinding+viewmodel+livedata组建mvvm
 */
class MainActivity : AppCompatActivity() {


    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // xml->kt代码绑定
        binding.myViewModel = myViewModel // 设置数据源
        binding.lifecycleOwner = this // 启动观察者

    }
}
