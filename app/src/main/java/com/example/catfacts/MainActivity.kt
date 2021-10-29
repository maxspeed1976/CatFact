package com.example.catfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfacts.model.CatResult
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        fetchJson()


    }

    fun fetchJson() {
        val url = "https://catfact.ninja/facts"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val catFact = gson.fromJson(body, CatResult::class.java)

                runOnUiThread {
                    recyclerView.adapter = CatFactAdapter(catFact.data)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute $e")
            }
        })


    }
}