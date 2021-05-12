package com.kachexiongdi.testroom.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kachexiongdi.testroom.bean.User
import kotlinx.coroutines.launch

/**
 *   author : qiukailong
 *   date   : 2021/5/12  11:30 上午
 *   desc   :
 */
class UserViewModel : ViewModel() {
    private lateinit var userRepository: UserRepository
    fun setContext(context: Context) {
        userRepository = UserRepository(context, this)
    }

    val usersLiveData: MutableLiveData<MutableList<User>> = MutableLiveData()
    fun getAllUsers() {
        viewModelScope.launch {
            val users = userRepository.getAllUsers()
            usersLiveData.postValue(users)
        }
    }

    fun insertUser(vararg users: User) {
        viewModelScope.launch {
            userRepository.insertUser(*users)
            getAllUsers()
        }
    }
}