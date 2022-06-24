package com.codetron.circularrecyclerview

import android.graphics.Color
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(
    val data: List<String> = listOf("A", "B", "C", "D", "E", "F", "G", "H")
) : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(TextView(parent.context).apply {
            width = parent.measuredWidth / 3
            setPadding(100)
            textSize = 50F
            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            setBackgroundColor(Color.GRAY)
        })
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.textView.text = data[position % data.size]
    }

    override fun getItemCount(): Int {
        return Integer.MAX_VALUE
    }

    inner class NameViewHolder(
        val textView: TextView
    ) : RecyclerView.ViewHolder(textView)

}