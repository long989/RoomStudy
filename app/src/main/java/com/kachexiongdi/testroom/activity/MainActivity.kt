package com.kachexiongdi.testroom.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kachexiongdi.testroom.MainAdapter
import com.kachexiongdi.testroom.R
import com.kachexiongdi.testroom.bean.ChildUser
import com.kachexiongdi.testroom.bean.User
import com.kachexiongdi.testroom.database.UserDataBase2
import com.kachexiongdi.testroom.databinding.ActivityMainBinding
import com.kachexiongdi.testroom.viewmodel.UserViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var mAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.setContext(this)

        val base = UserDataBase2.getInstance(this)
        //插入
        viewBinding.btnInsert.setOnClickListener {
            val user = User("刘德华", "男", "123")
            val user2 = User("刘德华", "男", "1234")
            userViewModel.insertUser(user, user2)
        }
        //查询
        viewBinding.btnQuery.setOnClickListener {
            userViewModel.getAllUsers()
        }
        initView()
        bindViewModel()
    }

    private fun initView() {
        mAdapter = MainAdapter()
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerView.adapter = mAdapter
    }

    private fun bindViewModel() {
        userViewModel.usersLiveData.observe(this, Observer {
            mAdapter.setUserList(it)
            for (user in it) {
                Log.e("user==", user.name + "--" + user.sex + "--" + user.id + "--" + user.uid)
            }
        })
    }
}