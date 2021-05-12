package com.kachexiongdi.testroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kachexiongdi.testroom.bean.ChildUser
import com.kachexiongdi.testroom.bean.User

/**
 *   author : qiukailong
 *   date   : 2020/12/4  2:13 PM
 *   desc   :
 */
@Dao
interface ChildUserDao {
    @Query("SELECT * FROM childuser")
   suspend fun getAllChildUser(): List<ChildUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChildUser(users: List<ChildUser>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertChildUser(users: ChildUser)

   //使用内连接查询
    @Query("SELECT * FROM childuser WHERE parentId = :userId")
    suspend fun getAllChildUserByUserId(userId: String): MutableList<ChildUser>
}