package com.example.mvvm.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.db.Word

class WordAdapter(private val context:Context) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var list = emptyList<Word>()
    private val listener: mClick = context as mClick


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val wordObject = list[position]
        holder.textView.text = wordObject.word
    }

    fun update(words:List<Word>){
        this.list = words

        //notify the user
        notifyDataSetChanged()

    }

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.word)
        val deleteImageView:ImageView = itemView.findViewById(R.id.delete)
        init {
            deleteImageView.setOnClickListener { listener.deleteClick(list[adapterPosition]) }
        }
    }


    interface mClick{
        fun deleteClick(word: Word)
    }
}