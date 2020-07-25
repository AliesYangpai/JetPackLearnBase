package org.phoneservice.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

/**
 * viewModel+liveData的初步使用，其中并使用了liveData的observe方法
 */
class MainActivity : AppCompatActivity() {


    val myViewModelWithLiveData by lazy { ViewModelProvider(this).get(MyViewModelWithLiveData::class.java) }

    lateinit var tv: TextView
    lateinit var btn1: ImageButton
    lateinit var btn2: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
        btn1 = findViewById(R.id.imageButton1)
        btn2 = findViewById(R.id.imageButton2)


        myViewModelWithLiveData.linkNum.observe(this, Observer {
            tv.text = it.toString()
        })

        btn1.setOnClickListener {
            myViewModelWithLiveData.addNumber(1)
        }

        btn2.setOnClickListener {

            myViewModelWithLiveData.addNumber(2)
        }
    }
}
