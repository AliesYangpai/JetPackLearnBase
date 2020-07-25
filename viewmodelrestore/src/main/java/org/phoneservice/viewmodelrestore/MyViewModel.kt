package org.phoneservice.viewmodelrestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * Created by Administrator on 2020/7/25 0025.
 * 类描述
 * 版本
 */
class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    /**
     * 个人理解：
     * 当Activity传入SavedStateViewModelFactory生成ViewModel的时候，这里的liveData应该使用
     * savedStateHandle.getLiveData<Int>(MainActivity.TAG)，如果直接使用MutableLiveData<Int>(0)
     * 会设置无效的
     */
    var scoreLiveData = savedStateHandle.getLiveData<Int>(MainActivity.TAG)

    fun addNumber(num: Int) {
        if (!savedStateHandle.contains(MainActivity.TAG)) {
            savedStateHandle.set(MainActivity.TAG, 0)
        }
        scoreLiveData = savedStateHandle.getLiveData<Int>(MainActivity.TAG)
        scoreLiveData.value = scoreLiveData.value?.plus(num)
    }


}