package com.assignment.myapplication.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assignment.myapplication.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.item1.view.*

class Article : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        Glide.with(this).load(intent.getStringExtra("url")).into(imageViewBG)
        tvAuthor.text=intent.getStringExtra("auth")
        tvDate.text=intent.getStringExtra("date")
        tvTittle.text=intent.getStringExtra("tittle")
        tvcontent.text=intent.getStringExtra("content")
    }
}