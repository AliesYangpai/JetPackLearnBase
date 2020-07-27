package org.phoneservice.roombase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.phoneservice.roombase.java.Person;
import org.phoneservice.roombase.java.PersonDao;
import org.phoneservice.roombase.java.PersonDataBase;

import java.util.List;

/**
 * 这里主要是为了演示java版本的room基本使用
 * 1.增删改查
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    private PersonDataBase personDataBase;
    private PersonDao personDao;
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
        // 先生成数据库
        personDataBase = Room
                .databaseBuilder(this, PersonDataBase.class, "PersonDataBase")
                .allowMainThreadQueries() // 不建调用此方法，这里仅用于测试使用
                .build();
        // 通过room获取数据库访问的dao对象
        personDao = personDataBase.getPersonDao();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                addPersonData();
                break;
            case R.id.btn2:
                deletePersonData();
                break;
            case R.id.btn3:
                updatePersonData();
                break;
            case R.id.btn4:
                showPersonData();
                break;
            case R.id.btn5:
                deleteAllPersonData();
                break;
        }
    }

    private void updatePersonData() {
        Person person = new Person("wangwu", 40);
        person.setId(17);
        personDao.updatePerson(person);

    }

    private void addPersonData() {
        Person person1 = new Person("张三", 10);
        Person person2 = new Person("李四", 20);
        Person person3 = new Person("王五", 30);
        personDao.insertPerson(person1, person2, person3);
    }

    private void deletePersonData() {
        Person person = new Person();
        person.setId(17);
        personDao.deletePerson(person);
    }

    private void showPersonData() {
        List<Person> allPerson = personDao.getAllPerson();
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : allPerson) {
            stringBuilder.append("id").append(person.getId())
                    .append("name:").append(person.getName())
                    .append("age:").append(person.getAge())
                    .append(";").append("\n");
        }
        tv.setText(stringBuilder);
    }

    private void deleteAllPersonData() {
        int i = personDao.deleteAllPerson();
        Log.i("Main2Activity", "删除的行数：i:" + i);
    }


}
