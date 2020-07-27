package org.phoneservice.roombase.kt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Administrator on 2020/7/27 0027.
 * 类描述
 * 版本
 */
@Entity
class Vehicle {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo(name = "vehicle_name")
    var name: String = ""
    @ColumnInfo(name = "vehicle_color")
    var color: String = ""

}