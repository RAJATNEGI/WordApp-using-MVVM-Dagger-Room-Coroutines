package com.example.mvvm.word

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),WordAdapter.mClick {

    private var viewModel: WordViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        var adapter = WordAdapter(this)
        val manager = LinearLayoutManager(this)

        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
        viewModel!!.words?.observe(this, Observer {
            it.let {
                //update the adapter
                adapter.update(it)
            }
        })

        save.setOnClickListener {
            viewModel!!.insert(Word(0, wordEt.text.toString()))
            wordEt.setText("")
        }


    }

    override fun deleteClick(word:Word) {
        viewModel?.delete(word)
    }
}
