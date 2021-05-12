package com.kachexiongdi.testroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kachexiongdi.testroom.bean.User

/**
 *   author : qiukailong
 *   date   : 2020/12/4  2:09 PM
 *   desc   :
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getUser(): MutableList<User>

    @Insert
    suspend fun insertUser(vararg users: User)
}