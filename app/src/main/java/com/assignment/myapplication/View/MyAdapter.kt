package com.assignment.myapplication.View

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myapplication.Model.Article
import com.assignment.myapplication.Model.MyModel
import com.assignment.myapplication.R
import com.assignment.myapplication.Source.Local.News

class MyAdapter(val context: Context,val list: List<MyModel>) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item1,parent,false)
        return MyHolder(view,context)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.Setdata(list[position])
        holder.itemview.setOnClickListener(View.OnClickListener {
            val intent= Intent(context,com.assignment.myapplication.View.Article::class.java)
            intent.putExtra("url",list[position].url)
            intent.putExtra("content",list[position].content)
            intent.putExtra("auth",list[position].auth)
            intent.putExtra("tittle",list[position].tittle)
            intent.putExtra("date",list[position].date)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}