package org.phoneservice.viewmodelrestore

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import org.phoneservice.viewmodelrestore.databinding.ActivityMainBinding

/**
 * 前言：
 * 1.viewModel绑定activity（fragment）后，当activity发生旋转，或切换到后台，或语言修改，viewmodel仍然存在
 * 但当activity被系统杀死时（这种情况是不会毁掉onDestroy()方法的），此时viewmodel也会被销毁，因此本案例
 * 就来完成Activity被杀死时，数据能够进行恢复
 * 【构造activity被杀死的场景：】
 * 开发者选项->应用->不保留活动
 */
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "Number"
    }

    private val myViewModel: MyViewModel by lazy {
        ViewModelProvider(
            this,
            SavedStateViewModelFactory(this.application, this)
        ).get(MyViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // 加载
        binding.myViewModel = myViewModel // 设置
        binding.lifecycleOwner = this // 绑定
    }


}
