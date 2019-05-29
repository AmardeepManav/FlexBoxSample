package com.flexboxsample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.flexboxsample.R
import kotlinx.android.synthetic.main.choose_mood_item_layout.view.*

class ChooseMoodAdapter(
    private val list: List<String>,
    private val listener: ClickListener) : RecyclerView.Adapter<ChooseMoodAdapter.ChooseMoodHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseMoodHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.choose_mood_item_layout, parent, false)
        return ChooseMoodHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ChooseMoodHolder, position: Int) {
        holder.name.text = list[position]
        holder.name.setOnClickListener {
            listener.onItemClickLister(holder.name, position)
        }
    }

    inner class ChooseMoodHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: CheckBox = itemView.choose_mood_item_name
    }

    interface ClickListener {
        fun onItemClickLister(name: CheckBox, postion: Int)
    }
}