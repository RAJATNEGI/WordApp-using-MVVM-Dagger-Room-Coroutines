package com.example.mvvm.word

import android.content.Context

class Repository(context: Context) {
    private var dao: WordDao = AppDatabase.getInstance(context)!!.wordDao()
    var getAllWord = dao.getAllWords()


    suspend fun insert(word: Word) {
        dao.insert(word)
    }

    suspend fun delete(word: Word) {
        dao.delete(word)
    }




}