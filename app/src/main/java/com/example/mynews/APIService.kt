package com.example.mynews

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @get:GET("/photos")
    val posts:Call<List<Post>>
}