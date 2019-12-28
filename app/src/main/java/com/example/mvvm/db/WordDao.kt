package com.example.mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm.db.Word

@Dao
interface WordDao {
    @Insert
    suspend fun insert(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("Select * from word_tb")
    fun getAllWords():LiveData<List<Word>>
}