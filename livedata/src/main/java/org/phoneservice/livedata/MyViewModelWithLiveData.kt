package org.phoneservice.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Administrator on 2020/7/24 0024.
 * 类描述
 * 版本
 */
class MyViewModelWithLiveData : ViewModel() {


    var linkNum = MutableLiveData<Int>(0)


    fun addNumber(num: Int) {
        linkNum.value = linkNum.value?.plus(num)

    }


}