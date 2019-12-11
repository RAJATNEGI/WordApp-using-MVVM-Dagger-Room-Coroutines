package com.example.mvvm.word

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_tb")
data class Word(@PrimaryKey(autoGenerate = true) val id: Int, val word: String)