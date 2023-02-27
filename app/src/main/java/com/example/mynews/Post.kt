package com.example.mynews

import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("id")
    var mId: Int = 0
    @SerializedName("title")
    var mTitle: String = ""
    @SerializedName("url")
    var mUrl: String = ""
}