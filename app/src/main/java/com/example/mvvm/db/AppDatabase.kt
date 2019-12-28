package com.example.mvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.db.Word
import com.example.mvvm.db.WordDao

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}