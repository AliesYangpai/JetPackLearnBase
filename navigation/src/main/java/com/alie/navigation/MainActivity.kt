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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

/**
 * 使用navigation的使用需要注意的是，我们需要使用Fragment来作为主容器，而不是Framlayout
 */
class MainActivity : AppCompatActivity() {
    lateinit var bnv: BottomNavigationView
    lateinit var fcv: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }


    private fun initView() {
        bnv = findViewById(R.id.bnv)
        fcv = findViewById(R.id.fcv)

    }

    private fun initListener() {


        val bundle = Bundle()
        bundle.putString(Const.FG_KEY, "你好")
        bnv.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.productFragment ->
                    fcv.findNavController().navigate(R.id.productFragment, bundle)
                R.id.msgFragment ->
                    fcv.findNavController().navigate(R.id.msgFragment, bundle)
                R.id.historyFragment ->
                    fcv.findNavController().navigate(R.id.historyFragment, bundle)
                R.id.mineFragment ->
                    fcv.findNavController().navigate(R.id.mineFragment, bundle)
            }
            true
        }
    }
}
