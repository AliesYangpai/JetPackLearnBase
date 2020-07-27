package org.phoneservice.roombase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {


    private lateinit var btn1: AppCompatButton
    private lateinit var btn2: AppCompatButton
    private lateinit var btn3: AppCompatButton
    private lateinit var btn4: AppCompatButton
    private lateinit var btnJump: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }


    private fun initView() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btnJump = findViewById(R.id.btn_jump)
    }

    private fun initListener() {
        btn1.setOnClickListener { }
        btn2.setOnClickListener { }
        btn3.setOnClickListener { }
        btn4.setOnClickListener { }
        btnJump.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}
