package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class HomeworkActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1)

        val nameText = findViewById<TextView>(R.id.name_text)
        val descriptionText = findViewById<TextView>(R.id.description_text)
        val idText = findViewById<TextView>(R.id.id_text)
        val priceText = findViewById<TextView>(R.id.price_text)
        val amountText = findViewById<TextView>(R.id.amount_text)

        GlobalScope.launch(Dispatchers.IO){
            val call = ProductRetrofitService.retrofit.create(ProductApiService::class.java).getProduct(2).execute().body()?.data
            val id = call?.id
            val name = call?.name
            val description = call?.description
            val price = call?.price
            val discountAmount = call?.discountAmount


            withContext(Dispatchers.Main){
                nameText.text = name ?: "Unknown"
                descriptionText.text = description ?: "No description"
                idText.text = (id ?: 0).toString()
                priceText.text = price ?: "0.0"
                amountText.text = discountAmount ?: "0.0"
            }

        }

    }
}