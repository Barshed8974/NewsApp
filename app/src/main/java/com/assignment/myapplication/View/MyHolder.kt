package com.assignment.myapplication.View

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myapplication.Model.MyModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item1.view.*

class MyHolder(var itemview: View,var context: Context): RecyclerView.ViewHolder(itemview) {
    fun Setdata(article: MyModel)
    {
        Glide.with(context).load(article.url).into(itemView.imageViewBG)
        itemview.tvTittle.text=article.tittle
        itemview.tvAuthor.text=article.auth
    }
}