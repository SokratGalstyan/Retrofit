package com.example.retrofit

import com.google.gson.annotations.SerializedName

class UserListModel {
    var page: Int? = null

    @SerializedName("per_page")
    var perPage: Int? = null

    var total: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    var data: List<UserData>? = null



    data class UserData(
            var id: Int,
            var email: String,
            @SerializedName("first_name")
            var firstName: String,
            @SerializedName("last_name")
            var lastName: String,
            var avatar: String
    )
}