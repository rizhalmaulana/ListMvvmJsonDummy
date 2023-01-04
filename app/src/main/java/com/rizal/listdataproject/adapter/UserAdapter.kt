package com.rizal.listdataproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rizal.listdataproject.databinding.ListItemBinding
import com.rizal.listdataproject.model.User

class UserAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var users = mutableListOf<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUserList(users: List<User>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]

        holder.binding.tvTitle.text = user.title
        holder.binding.tvBody.text = user.body
    }

    override fun getItemCount(): Int = users.size

    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}