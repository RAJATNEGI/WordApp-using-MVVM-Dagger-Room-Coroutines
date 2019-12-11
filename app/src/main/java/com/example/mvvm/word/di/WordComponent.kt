package com.example.mvvm.word.di

import com.example.mvvm.word.Word
import dagger.Component

@Component
interface WordComponent {
     fun getWord():Word
 }