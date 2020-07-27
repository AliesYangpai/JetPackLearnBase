package org.phoneservice.roombase.java;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述 activity 过于臃肿，此处使用ViewModel
 * 版本  注意：ViewModel的职责是管理界面的数据，而不是"直接"获取界面的数据，
 * 也就是说要有个repository来直接获取数据交给ViewModel ，注意，这里的管理值得是数据获取的封装处理
 */
public class PersonViewModel extends AndroidViewModel {

    private PersonRepository personRepository;

    public PersonViewModel(@NonNull Application application) {
        super(application);
    }



    public void addData() {
        personRepository.addPersonData();
    }

    public void deleteData() {
        personRepository.deletePersonData();
    }

    public void deleteAllData() {
        personRepository.deleteAllPersonData();
    }

    public void updateData() {
        personRepository.updatePersonData();
    }

    public LiveData<List<Person>> getAllData() {
        return personRepository.getAllLiveData();
    }


}
