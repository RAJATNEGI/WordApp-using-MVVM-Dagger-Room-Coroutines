package com.example.mvvm.db

import androidx.lifecycle.LiveData
import com.example.mvvm.db.Word

interface LocalDataSource {
   suspend fun insert(word: Word)
   suspend fun delete(word: Word)
   fun getAllWords():LiveData<List<Word>>

}
