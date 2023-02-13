package com.example.practicehelper

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicehelper.databinding.ActivityDefinitionBinding

class DefinitionActivity : AppCompatActivity() {
    lateinit var binding:ActivityDefinitionBinding
    lateinit var prefContent:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefinitionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefContent = getSharedPreferences("CONTENT", MODE_PRIVATE)
        getDefinition()
    }
    fun getDefinition(){
        var definition = intent.getStringExtra("definition")
        binding.tvDefinition.text = definition
        val content = prefContent.getString("$definition","")
        binding.tvContent.text = content
    }
}