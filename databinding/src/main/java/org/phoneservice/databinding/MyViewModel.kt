package org.phoneservice.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Administrator on 2020/7/24 0024.
 * 类描述
 * 版本
 */
class MyViewModel : ViewModel() {
    val numLiveData = MutableLiveData<Int>(0)


    fun addNum(num: Int) {
        numLiveData.also {
            it.value = it.value?.plus(num)
        }
    }

    fun getNum(): MutableLiveData<Int>? {
        return numLiveData
    }

}