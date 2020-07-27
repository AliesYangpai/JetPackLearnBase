package org.phoneservice.roombase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.phoneservice.roombase.java.Person;
import org.phoneservice.roombase.java.PersonViewModel;

import java.util.List;

/**
 * 这里主要是为了演示java版本的room使用
 * 基本使用：
 * 1.增删改查
 * 进阶使用：
 * 1.加入ViewModel+LiveData+Repository 与异步(这里异步还我没有实现 ╮(╯▽╰)╭)
 *  到目前为止，我感觉目前还是有点像mvp ，0.0
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private PersonViewModel personViewModel;
    private TextView tv;
    private AppCompatButton btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        tv = findViewById(R.id.textView);
    }

    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    /**
     * 关键代码
     */
    private void initData() {


        personViewModel = new PersonViewModel(this.getApplication());
        personViewModel.getAllData().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> allPerson) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Person person : allPerson) {
                    stringBuilder.append("id").append(person.getId())
                            .append("name:").append(person.getName())
                            .append("age:").append(person.getAge())
                            .append("hobby:").append(person.getHobby())
                            .append(";").append("\n");
                }
                tv.setText(stringBuilder);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                personViewModel.addData();
                break;
            case R.id.btn2:
                personViewModel.deleteData();
                break;
            case R.id.btn3:
                personViewModel.updateData();
                break;
            case R.id.btn4:
                personViewModel.getAllData();
                break;
            case R.id.btn5:
                personViewModel.deleteAllData();
                break;
        }
    }


}
