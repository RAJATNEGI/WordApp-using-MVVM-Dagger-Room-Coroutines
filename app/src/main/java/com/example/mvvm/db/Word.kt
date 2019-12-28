package com.example.mvvm.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "word_tb")
data class Word  constructor(@PrimaryKey(autoGenerate = true) var id: Int, var word: String)