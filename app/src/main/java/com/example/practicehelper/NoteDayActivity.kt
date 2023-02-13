package com.example.practicehelper

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.practicehelper.databinding.ActivityNoteDayBinding
import kotlinx.android.synthetic.main.activity_note_day.*

class NoteDayActivity : AppCompatActivity() {

    lateinit var binding: ActivityNoteDayBinding
    var pref : SharedPreferences? = null
    private var numberOfNote: Char = '0'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var day = intent.getStringExtra("day")
        numberOfNote = day!![day.length-1]
        pref = getSharedPreferences("NOTES", Context.MODE_PRIVATE)
        getNote()
    }

    private fun getNote(){
        val note = pref?.getString("note $numberOfNote","")
        binding.etNote.setText(note)

    }

    fun btBackOnClick(view: View){
        finish()
    }

    fun btSaveOnClick(view: View){
        val note = binding.etNote.text.toString()
        var editor = pref?.edit()
        editor?.putString("note $numberOfNote",note)
        editor?.apply()
    }
}