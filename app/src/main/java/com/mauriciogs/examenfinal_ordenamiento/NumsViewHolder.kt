package com.mauriciogs.examenfinal_ordenamiento

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumsViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val number = view.findViewById<TextView>(R.id.tv_num)

    fun render(numModel : Int){
        number.text = numModel.toString()
    }
}