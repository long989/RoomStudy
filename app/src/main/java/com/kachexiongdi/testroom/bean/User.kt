package com.kachexiongdi.testroom.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   author : qiukailong
 *   date   : 2020/12/4  10:25 AM
 *   desc   :
 */
@Entity(tableName = "user")
class User(
    var name: String = "",
    var sex: String = "",
    var uid: String = "",
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

) {
}