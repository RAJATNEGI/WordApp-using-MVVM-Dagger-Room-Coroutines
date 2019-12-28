package com.example.mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.db.Repository
import com.example.mvvm.db.Word
import kotlinx.coroutines.launch
import javax.inject.Inject

class WordViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    var words: LiveData<List<Word>> = repository.getAllWords()


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
}