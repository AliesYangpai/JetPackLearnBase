package com.alie.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


/**
 * 使用navigation的使用需要注意的是，我们需要使用Fragment来作为主容器，而不是Framlayout
 *
 * 此案例展示的是标准用法，最底部的注释代码是低级用法
 * nav设置后，会默认选中首页的
 */
class MainActivity : AppCompatActivity() {
    lateinit var mBottomNavigationView: BottomNavigationView
    lateinit var mNavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }


    private fun initView() {
        /**
         * 参考：
         * https://stackoverflow.com/questions/58703451/fragmentcontainerview-as-navhostfragment
         * 关于navGraph所在控件的说明，这里有点小坑，需要注意
         * 如果是<FragmentContainerView>标签对于NavController 获取如下
         * 使用 supportFragmentManager 先找到NavHostFragment，用NavHostFragment去获取findNavController
         */
        mBottomNavigationView = findViewById(R.id.bnv)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv) as NavHostFragment
        mNavController = navHostFragment.navController
        /**
         * 给mBottomNavigationView设置navController 以下方法二选一：
         *  NavigationUI.setupWithNavController(mBottomNavigationView,mNavController)
         *  mBottomNavigationView.setupWithNavController(mNavController)
         */
        mBottomNavigationView.setupWithNavController(mNavController)
//        NavigationUI.setupWithNavController(mBottomNavigationView,mNavController)
    }

    private fun initListener() {
        mNavController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.productFragment ->
                    Log.i("MainActivity","===productFragment")
                R.id.msgFragment ->
                    Log.i("MainActivity","===msgFragment")
                R.id.historyFragment->
                    Log.i("MainActivity","===historyFragment")
                R.id.mineFragment->
                    Log.i("MainActivity","===mineFragment")
            }
        }
    }
}


/**
 * 使用navigation的使用需要注意的是，我们需要使用Fragment来作为主容器，而不是Framlayout
 * 此案例展示的是初级用法
 */
//class MainActivity : AppCompatActivity() {
//    lateinit var bnv: BottomNavigationView
//    lateinit var mNavController: NavController
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        initView()
//        initListener()
//    }
//
//
//    private fun initView() {
//        bnv = findViewById(R.id.bnv)
//
//        /**
//         *  关于navGraph所在控件的说明，这里有点小坑，需要注意
//         *  如果是<fragment>标签对于NavController 获取如下
//         *  因为标签是<fragment> 所以不必使用supportFragmentManager
//         *  直接获取到到 mNavController(fragment 中设置了) 参考方法：
//         *   Fragment.findNavController()
//         *   View.findNavController()
//         *   Activity.findNavController(viewId: Int)
//         */
//        mNavController = findNavController(R.id.fcv)
//
//        /**
//         * 参考：
//         * https://stackoverflow.com/questions/58703451/fragmentcontainerview-as-navhostfragment
//         * 关于navGraph所在控件的说明，这里有点小坑，需要注意
//         * 如果是<FragmentContainerView>标签对于NavController 获取如下
//         * 使用 supportFragmentManager 先找到NavHostFragment，用NavHostFragment去获取findNavController
//         */
////        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv) as NavHostFragment
////        mNavController = navHostFragment.navController
//    }
//
//    private fun initListener() {
//
//        val bundle = Bundle()
//        bundle.putString(Const.FG_KEY, "你好")
//        bnv.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.productFragment ->
//                    mNavController.navigate(R.id.productFragment, bundle)
//                R.id.msgFragment ->
//                    mNavController.navigate(R.id.msgFragment, bundle)
//                R.id.historyFragment ->
//                    mNavController.navigate(R.id.historyFragment, bundle)
//                R.id.mineFragment ->
//                    mNavController.navigate(R.id.mineFragment, bundle)
//            }
//            true
//        }
//    }
//}
