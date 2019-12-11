package com.example.mvvm.word

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository = Repository(application.applicationContext)
    var words: LiveData<List<Word>> =  repository.getAllWord


     fun insert(word: Word) {
        viewModelScope.launch {
            repository.insert(word)
        }

    }

     fun delete(word: Word) {
        viewModelScope.launch {
            repository.delete(word)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}