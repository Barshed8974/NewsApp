package com.assignment.myapplication.Source.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.assignment.myapplication.Model.Article


@Database(entities = [News::class],version = 3)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getTaskDAO(): NewsDao

    companion object {

        private var INSTANCE: NewsDatabase? = null

        fun getDatabaseObject(context: Context): NewsDatabase {

            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "News_DB"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}
