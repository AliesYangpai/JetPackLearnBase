package org.phoneservice.roombase.kt

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
class VehicleRepository(context: Context) {

    private var vehicleDataBase: VehicleDataBase? = null
    private var vehicleDao: VehicleDao? = null

    init {
        vehicleDataBase =
            Room.databaseBuilder(context, VehicleDataBase::class.java, "vehicleDataBase")
                .allowMainThreadQueries()
                .build()
        vehicleDao = vehicleDataBase?.getVehicleDao()
    }

    fun getAllData(): LiveData<List<Vehicle>>? {
        return vehicleDao?.getAllData()
    }

    fun addData() {
        val vehicle1 = Vehicle()
        vehicle1.name = "法拉利"
        vehicle1.color = "red"

        val vehicle2 = Vehicle()
        vehicle2.name = "迈凯伦"
        vehicle2.color = "blue"

        val vehicle3 = Vehicle()
        vehicle3.name = "兰博基尼"
        vehicle3.color = "yellow"
        vehicleDao?.insert(vehicle1, vehicle2, vehicle3)
    }

    fun deleteData(): Int? {
        val vehicle = Vehicle()
        vehicle.id = 17
        return vehicleDao?.delete(vehicle)
    }


    fun updateData(): Int? {
        val vehicle = Vehicle()
        vehicle.name = "保时捷"
        vehicle.color = "红色"
        vehicle.id = 15
        return vehicleDao?.update(vehicle)
    }

    fun deleteAllData(): Int? {
        return vehicleDao?.deleteAll()
    }
}