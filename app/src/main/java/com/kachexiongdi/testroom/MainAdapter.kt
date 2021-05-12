package com.kachexiongdi.testroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kachexiongdi.testroom.bean.User
import com.kachexiongdi.testroom.databinding.ItemBinding

/**
 *   author : qiukailong
 *   date   : 2021/5/12  1:40 下午
 *   desc   :
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var mUserList: MutableList<User> = arrayListOf()

    fun setUserList(userList: MutableList<User>) {
        mUserList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemBinding = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(parent.context), R.layout.item, null, false
        )
        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.mItemBinding?.user = mUserList[position]
    }

    override fun getItemCount(): Int {
        return mUserList.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItemBinding: ItemBinding? = null

        constructor(itemBinding: ItemBinding) : this(itemBinding.root) {
            mItemBinding = itemBinding
        }

    }

}