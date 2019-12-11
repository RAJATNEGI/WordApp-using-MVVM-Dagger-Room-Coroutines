package com.example.mvvm.word

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "word_tb")
data class Word @Inject constructor(@PrimaryKey(autoGenerate = true) val id: Int, val word: String)