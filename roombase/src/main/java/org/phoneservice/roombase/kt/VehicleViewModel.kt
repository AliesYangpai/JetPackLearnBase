package org.phoneservice.roombase.kt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述 这里要使用application 因此要继承AndroidViewModel
 * 版本
 */
class VehicleViewModel(application: Application) : AndroidViewModel(application) {
    private var vehicleRepository: VehicleRepository? = null

    init {
        vehicleRepository = VehicleRepository(application)
    }

    fun addVehicle() {
        vehicleRepository?.addData()
    }

    fun deleteVehicle(): Int? {
        return vehicleRepository?.deleteData()
    }

    fun updateVehicle(): Int? {
        return vehicleRepository?.updateData()
    }

    fun deleteAllVehicle(): Int? {
        return vehicleRepository?.deleteAllData()
    }

    fun getAllVehicle(): LiveData<List<Vehicle>>? {
        return vehicleRepository?.getAllData()
    }
}