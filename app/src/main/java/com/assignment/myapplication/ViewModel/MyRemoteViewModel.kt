package com.assignment.myapplication.ViewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assignment.myapplication.Repository.MyRemoteRepository
import com.assignment.myapplication.Source.Local.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRemoteViewModel (private val repo: MyRemoteRepository) : ViewModel(){
    fun getNews()
    {
        CoroutineScope(Dispatchers.IO).launch {
            repo.getNews()
        }
    }
    fun getDataFromDataBase():LiveData<List<News>>
    {
        var list=repo.getAllTasksFromTable()
        Log.d("Jhony"," getDataFromDataBase viewModel  ${list.value?.size}")
        return list
    }
}
