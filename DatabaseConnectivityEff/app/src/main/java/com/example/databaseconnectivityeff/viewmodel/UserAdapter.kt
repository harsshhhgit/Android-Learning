package com.example.databaseconnectivityeff.viewmodel

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseconnectivityeff.R
import com.example.databaseconnectivityeff.UpdateActivity
import com.example.databaseconnectivityeff.entity.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    var users: List<User> = ArrayList()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var cardView= itemView.findViewById<CardView>(R.id.cardView)
        var title = itemView.findViewById<TextView>(R.id.usernameCard)
        var pwd = itemView.findViewById<TextView>(R.id.passwordCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user: User = users[position]
        Log.d("position", "$position")
        holder.title.text = user.username
        holder.pwd.text = user.password

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java)
            Log.d("position", "$position clicked")
            intent.putExtra("username", holder.title.text)
            intent.putExtra("pwd", holder.pwd.text)
            intent.putExtra("position", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    fun setDBUsers(users: List<User>){
//        Log.d("usersData", users.size.toString())
        this.users = users
        notifyDataSetChanged()
    }
}