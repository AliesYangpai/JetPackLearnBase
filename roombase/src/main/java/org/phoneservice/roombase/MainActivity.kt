package org.phoneservice.roombase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.phoneservice.roombase.kt.VehicleViewModel

/**
 *
 */
class MainActivity : AppCompatActivity() {


    private val vehicleViewModel: VehicleViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(
            VehicleViewModel::class.java
        )
    }


    private lateinit var tv: TextView
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
        initData()
    }


    private fun initView() {
        tv = findViewById(R.id.textView)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btnJump = findViewById(R.id.btn_jump)
    }

    private fun initListener() {
        btn1.setOnClickListener {
            vehicleViewModel.addVehicle()
        }
        btn2.setOnClickListener {
            vehicleViewModel.deleteVehicle()
        }
        btn3.setOnClickListener {
            vehicleViewModel.updateVehicle()
        }
        btn4.setOnClickListener {
            vehicleViewModel.deleteAllVehicle()
        }


        btnJump.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun initData() {
        vehicleViewModel.getAllVehicle()?.observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach {
                stringBuilder
                    .append("名称:").append(it.name)
                    .append("颜色:").append(it.color)
                    .append(";").append("\n")
                tv.text = stringBuilder
            }
        })
    }
}
