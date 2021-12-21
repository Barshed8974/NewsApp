package com.assignment.myapplication.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.myapplication.Model.Article
import com.assignment.myapplication.Model.MyModel
import com.assignment.myapplication.R
import com.assignment.myapplication.Repository.MyRemoteRepository
import com.assignment.myapplication.Source.Local.NewsDatabase
import com.assignment.myapplication.ViewModel.MyLocalViewModelProvider
import com.assignment.myapplication.ViewModel.MyRemoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     var list =ArrayList<MyModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel=ViewModelProviders.of(this,MyLocalViewModelProvider(
            MyRemoteRepository(NewsDatabase.getDatabaseObject(this).getTaskDAO()))).get(MyRemoteViewModel::class.java)
        viewModel.getNews()
        viewModel.getDataFromDataBase().observe(this,{
            it.forEach {
                if(it.author.length>1&&it.title.length>1&&it.urlToImage.length>1&&it.content.length>1&&it.date.length>1)
                {
                    list.add(MyModel(it.urlToImage,it.content,it.author,it.title,it.date))
                    Log.d("ALI",it.author)
                }
            }
            recycler.adapter=MyAdapter(this,list)
            recycler.layoutManager=LinearLayoutManager(this)
        })
    }
}