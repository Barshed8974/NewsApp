package com.assignment.myapplication.Source.Local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "newsDataBase")
data class News (
    @ColumnInfo(name = "Author")
    var author:String,
    @ColumnInfo(name = "Source")
    var content:String,
    @ColumnInfo(name = "Title")
    var title:String,
    @ColumnInfo(name = "UrlToImage")
    var urlToImage:String,
    @ColumnInfo(name = "date")
    var date:String,
        ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
