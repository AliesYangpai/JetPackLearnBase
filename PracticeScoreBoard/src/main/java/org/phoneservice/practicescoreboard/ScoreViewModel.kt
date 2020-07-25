package org.phoneservice.practicescoreboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Administrator on 2020/7/24 0024.
 * 类描述
 * 版本
 */
class ScoreViewModel : ViewModel() {
    val teamAliveData = MutableLiveData<Int>(0)
    val teamBliveData = MutableLiveData<Int>(0)


    fun addTeamAscore(score: Int) {
        teamAliveData.also {
            it.value = it.value?.plus(score)
        }
    }

    fun addTeamBscore(score: Int) {
        teamBliveData.also {
            it.value = it.value?.plus(score)
        }
    }

    fun clearAll() {
        teamAliveData.also {
            it.value = 0
        }

        teamBliveData.also {
            it.value = 0
        }
    }


}