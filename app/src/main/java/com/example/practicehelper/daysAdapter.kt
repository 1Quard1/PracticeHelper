package com.example.practicehelper

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DaysAdapter(private val days:ArrayList<String>, private val onClickListener:DaysOnClickListener) : RecyclerView.Adapter<DaysAdapter.DayViewHolder>(){

    inner class DayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTV: TextView = view.findViewById<View>(R.id.dayTV) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.days_item, parent, false)
        return DayViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day: String = days[position]
        holder.dayTV.text = day
        holder.dayTV.setOnClickListener{
            onClickListener.onClicked(day)
        }
    }

    override fun getItemCount(): Int {
        return days.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun confirmChanged(){
        notifyDataSetChanged()
    }
}