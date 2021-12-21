package com.assignment.myapplication.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.myapplication.Repository.MyRemoteRepository

class MyLocalViewModelProvider (private  val repo: MyRemoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("ALI","Factory")
        return MyRemoteViewModel(repo) as T
    }
}