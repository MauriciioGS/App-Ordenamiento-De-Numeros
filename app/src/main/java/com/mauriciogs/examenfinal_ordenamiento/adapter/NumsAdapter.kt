package com.mauriciogs.examenfinal_ordenamiento.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mauriciogs.examenfinal_ordenamiento.NumsViewHolder
import com.mauriciogs.examenfinal_ordenamiento.R

class NumsAdapter(
    val numlist : ArrayList<Int>
) : RecyclerView.Adapter<NumsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NumsViewHolder(layoutInflater.inflate(R.layout.item_num, parent, false))
    }

    override fun onBindViewHolder(holder: NumsViewHolder, position: Int) {
        val item = numlist[position]
        holder.render(item)
    }

    override fun getItemCount() : Int = numlist.size
}