package com.example.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Callback<List<Post>> {
    val mPosts:MutableList<Post> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = PostAdaptor(this, mPosts)

        initData()
    }

    private fun initData() {
        API.apiService.posts.enqueue(this)
    }

    override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
        if (response==null || response.body()==null){
            return
        }

        mPosts.addAll(response.body()!!)
        recycleView.adapter!!.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}