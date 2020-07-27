package org.phoneservice.roombase.kt

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Dao
interface VehicleDao {
    @Insert
    fun insert(vararg vehicle: Vehicle)

    @Delete
    fun delete(vararg vehicle: Vehicle): Int

    @Update
    fun update(vararg vehicle: Vehicle): Int

    @Query(value = "delete from vehicle")
    fun deleteAll(): Int

    @Query(value = "select * from vehicle order by id asc")
    fun getAllData(): LiveData<List<Vehicle>>

}