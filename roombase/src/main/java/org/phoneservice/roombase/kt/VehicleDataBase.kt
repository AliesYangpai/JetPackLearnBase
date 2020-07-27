package org.phoneservice.roombase.kt

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Database(entities = [Vehicle::class], version = 1,exportSchema = false)
abstract class VehicleDataBase : RoomDatabase() {
    abstract fun getVehicleDao(): VehicleDao
}