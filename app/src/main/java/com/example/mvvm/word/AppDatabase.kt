package com.example.mvvm.word

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private var db: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (db == null) {
                synchronized(this) {
                    db = Room.databaseBuilder(context, AppDatabase::class.java, "word_db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return db
        }
    }
}