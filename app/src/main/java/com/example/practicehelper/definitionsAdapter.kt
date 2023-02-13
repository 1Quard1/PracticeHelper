package com.example.practicehelper

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DefinitionsAdapter(private val definitions:ArrayList<String>, private val onClickListener:DefinitionsOnClickListener) : RecyclerView.Adapter<DefinitionsAdapter.DefinitionViewHolder>(){

    inner class DefinitionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val definitionTV: TextView = view.findViewById<View>(R.id.definitionTV) as TextView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.definitions_item, parent, false)
        return DefinitionViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) {
        val definition: String = definitions[position]
        holder.definitionTV.text = definition
        holder.definitionTV.setOnClickListener{
            onClickListener.onClicked(definition)
        }
    }
    override fun getItemCount(): Int {
        return definitions.size
    }
}