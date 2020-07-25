package org.phoneservice.practicescoreboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.phoneservice.practicescoreboard.databinding.ActivityMainBinding

/**
 * 使用 databinding + viewmodel（livedata） 进行的记分牌功能
 */
class MainActivity : AppCompatActivity() {


    val mScoreViewModel by lazy { ViewModelProvider(this).get(ScoreViewModel::class.java) }
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.scoreViewModel = mScoreViewModel
        mBinding.lifecycleOwner = this
    }



}
