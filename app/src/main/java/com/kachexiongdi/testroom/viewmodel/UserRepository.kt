package com.kachexiongdi.testroom.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.kachexiongdi.testroom.bean.User
import com.kachexiongdi.testroom.dao.UserDao
import com.kachexiongdi.testroom.database.UserDataBase2
import kotlinx.coroutines.launch

/**
 *   author : qiukailong
 *   date   : 2021/5/12  11:23 上午
 *   desc   :
 */
class UserRepository {
    private lateinit var userDao: UserDao
    private lateinit var viewModel: ViewModel

    constructor(context: Context, viewModel: ViewModel) : super() {
        this.viewModel = viewModel
        userDao = UserDataBase2.getInstance(context).userDao
    }

   suspend fun insertUser(vararg users: User) {
        userDao.insertUser(*users)
    }

    suspend fun getAllUsers(): MutableList<User> {
       return userDao.getUser()
    }
}