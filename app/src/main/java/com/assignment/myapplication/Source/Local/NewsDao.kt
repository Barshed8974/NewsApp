package com.assignment.myapplication.Source.Local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.assignment.myapplication.Model.Article


@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(news: News)

    @Query("select * from newsDataBase")
    fun getTasks(): LiveData<List<News>>

}
