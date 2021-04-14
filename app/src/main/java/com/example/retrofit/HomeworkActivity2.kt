package com.example.retrofit

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class HomeworkActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2)
        val context = this
        val recycler = findViewById<RecyclerView>(R.id.user_list)

        GlobalScope.launch(Dispatchers.IO) {
            val data = UserRetrofitService.retrofit.create(UserApiService::class.java).getUserList(2).execute().body()?.data

            withContext(Dispatchers.Main){
                if (data != null){
                    val adapter = RecyclerAdapter(context, data)
                    recycler.adapter = adapter
                    recycler.layoutManager = LinearLayoutManager(context)
                }
            }
        }
    }
}