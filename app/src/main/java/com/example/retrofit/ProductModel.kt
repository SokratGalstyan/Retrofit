package com.example.retrofit

import com.google.gson.annotations.SerializedName

class ProductModel {
    var code: Long? = null
    var meta: Any? = null
    var data: ProductData? = null


    data class ProductData(
        var id: Int,
        var name: String,
        var description: String,
        var image: String,
        var price: String,
        @SerializedName("discount_amount")
        var discountAmount: String,
        var status: Boolean,
        val categories: List<Category>
    )

    data class Category(
        val id: Long,
        val name: String
    )
}