package com.example.retrofit

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.net.URL

class RecyclerAdapter(val context: Context, val data: List<UserListModel.UserData>?): RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {


    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        val avatar: ImageView
        val id: TextView
        val email: TextView
        val firstName: TextView
        val lastName: TextView

        init {
            avatar = view.findViewById(R.id.avatar)
            id = view.findViewById(R.id.user_id)
            email = view.findViewById(R.id.email)
            firstName = view.findViewById(R.id.first_name)
            lastName = view.findViewById(R.id.last_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val current = data?.get(position)
        if (current != null) {
            Picasso.get().load(current.avatar).into(holder.avatar)
            holder.id.text = (current.id).toString()
            holder.email.text = current.email
            holder.firstName.text = current.firstName
            holder.lastName.text = current.lastName
        }

    }

    override fun getItemCount(): Int {
        return  data?.size ?: 0
    }
}