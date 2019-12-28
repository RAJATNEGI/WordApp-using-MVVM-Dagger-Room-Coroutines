package com.example.mvvm.di

import android.app.Application
import androidx.room.Room
import com.example.mvvm.db.AppDatabase
import com.example.mvvm.db.WordDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class DbModule constructor(private val app: Application) {


    @Singleton
    @Provides
    fun provideDb(): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "word_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase): WordDao {
        return db.wordDao()
    }


}