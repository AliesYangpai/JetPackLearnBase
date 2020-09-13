package com.alie.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

/**
 * 使用navigation的使用需要注意的是，我们需要使用Fragment来作为主容器，而不是Framlayout
 */
class MainActivity : AppCompatActivity() {
    lateinit var bnv: BottomNavigationView
    lateinit var mNavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }


    private fun initView() {
        bnv = findViewById(R.id.bnv)

        /**
         *  关于navGraph所在控件的说明，这里有点小坑，需要注意
         *  如果是<fragment>标签对于NavController 获取如下
         *  因为标签是<fragment> 所以不必使用supportFragmentManager
         *  直接获取到到 mNavController(fragment 中设置了) 参考方法：
         *   Fragment.findNavController()
         *   View.findNavController()
         *   Activity.findNavController(viewId: Int)
         */
        mNavController = findNavController(R.id.fcv)



        /**
         * 参考：
         * https://stackoverflow.com/questions/58703451/fragmentcontainerview-as-navhostfragment
         * 关于navGraph所在控件的说明，这里有点小坑，需要注意
         * 如果是<FragmentContainerView>标签对于NavController 获取如下
         * 使用 supportFragmentManager 先找到NavHostFragment，用NavHostFragment去获取findNavController
         */
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv) as NavHostFragment
//        mNavController = navHostFragment.navController
    }

    private fun initListener() {


        val bundle = Bundle()
        bundle.putString(Const.FG_KEY, "你好")
        bnv.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.productFragment ->
                    mNavController.navigate(R.id.productFragment, bundle)
                R.id.msgFragment ->
                    mNavController.navigate(R.id.msgFragment, bundle)
                R.id.historyFragment ->
                    mNavController.navigate(R.id.historyFragment, bundle)
                R.id.mineFragment ->
                    mNavController.navigate(R.id.mineFragment, bundle)
            }
            true
        }
    }
}
