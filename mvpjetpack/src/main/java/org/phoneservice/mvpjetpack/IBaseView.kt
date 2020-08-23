package org.phoneservice.mvpjetpack

/**
 * Created by Administrator on 2020/8/23 0023.
 * 类描述
 * 版本
 */
interface IBaseView {
    fun showLoading()
    fun stopLoading()
    fun showToast(msg:String)
}