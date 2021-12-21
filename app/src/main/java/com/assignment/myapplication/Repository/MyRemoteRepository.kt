package com.assignment.myapplication.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.myapplication.Model.Article
import com.assignment.myapplication.Source.Local.News
import com.assignment.myapplication.Source.Local.NewsDao
import com.assignment.myapplication.Source.Remote.ApiServices
import com.assignment.myapplication.Source.Remote.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRemoteRepository(private val newsDao: NewsDao){
    suspend fun getNews() {
        try {

            Network.getApiServices().getNews().articles.forEach {
                addNews(
                    News(""+it.author,""+it.description,""+it.title,""+it.urlToImage,""+it.publishedAt)
                )
            }
        }catch (esc: Exception)
        {
            
        }
        Log.d("ALI", "ll")
    }
    fun addNews(news: News)
    {
        CoroutineScope(Dispatchers.IO).launch {

            newsDao.addTask(news) }
    }
    fun getAllTasksFromTable() :LiveData<List<News>>{
        var list=newsDao.getTasks()
        Log.d("Jhony"," getAllTasksFromTable  Repo  ${list.value?.size}")
        return list
    }
}

