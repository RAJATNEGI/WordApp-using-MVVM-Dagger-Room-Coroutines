package com.example.mvvm.db

import androidx.lifecycle.LiveData
import javax.inject.Inject

class Repository @Inject constructor(val dao: WordDao) :
    LocalDataSource {

    override suspend fun insert(word: Word) {
        dao.insert(word)
    }

    override suspend fun delete(word: Word) {
        dao.delete(word)
    }

    override fun getAllWords(): LiveData<List<Word>> {
       return dao.getAllWords()
    }


}