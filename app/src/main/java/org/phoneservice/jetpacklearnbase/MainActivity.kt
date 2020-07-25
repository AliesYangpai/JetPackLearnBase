package org.phoneservice.jetpacklearnbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ViewModel的单独使用
 */
class MainActivity : AppCompatActivity() {

    val myViewModel: MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }


    lateinit var tv1: TextView
    lateinit var button1: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.textView)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        tv1.text = myViewModel.number.toString()
        button1.setOnClickListener {
            myViewModel.number += 1
            textView.text = myViewModel.number.toString()
        }


        button2.setOnClickListener {
            myViewModel.number += 2
            textView.text = myViewModel.number.toString()
        }

    }
}
