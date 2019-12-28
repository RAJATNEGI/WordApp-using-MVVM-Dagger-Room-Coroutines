package com.example.mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.App
import com.example.mvvm.R
import com.example.mvvm.db.Word
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(),
    WordAdapter.mClick {


    @Inject
    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).getComponent().inject(this)

//        viewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        var adapter = WordAdapter(this)
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter


        viewModel.words.observe(this, Observer {
            it.let {
                //update the adapter
                adapter.update(it)
            }
        })



        save.setOnClickListener {
            viewModel.insert(
                Word(
                    0,
                    wordEt.text.toString()
                )
            )
            wordEt.setText("")
        }


    }

    override fun deleteClick(word: Word) {
        viewModel.delete(word)
    }
}
