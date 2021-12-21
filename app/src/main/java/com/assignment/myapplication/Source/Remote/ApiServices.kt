package com.assignment.myapplication.Source.Remote

import androidx.lifecycle.LiveData
import com.assignment.myapplication.Model.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("/v2/top-headlines?country=us&apiKey=c4dd066bd33c443283becd619e6092e6")
    suspend fun getNews() :Response
}
