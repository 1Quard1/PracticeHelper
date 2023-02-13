package com.example.practicehelper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicehelper.databinding.ActivityDiaryBinding
import kotlinx.android.synthetic.main.activity_diary.*

class DiaryActivity : AppCompatActivity() {
    lateinit var binding: ActivityDiaryBinding
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("DAYS", Context.MODE_PRIVATE)

        createList()
    }

    fun createList(){
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        daysRV.layoutManager = linearLayoutManager
        val days = ArrayList<String>()
        val numberOfDays = pref?.getInt("days",0)
        var countOfDays = 1
        while (days.size < numberOfDays!!){
            days.add("День $countOfDays")
            countOfDays++
        }
        val adapter = DaysAdapter(days, object : DaysOnClickListener{
            override fun onClicked(day: String) {
                startNoteActivity(day)
            }
        })
        daysRV.adapter = adapter
        binding.btAddDay.setOnClickListener{
            days.add("День ${days.size + 1}")
            saveDays(days.size)
            adapter.confirmChanged()
        }
    }

    fun startNoteActivity(day:String){
        val intent = Intent(this,NoteDayActivity::class.java)
        intent.putExtra("day",day)
        startActivity(intent)
    }
    fun btNavHomeOnClick(view: View){
        finish()
    }
    fun btNavProfileOnClick(view: View){
        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btNavGlossaryOnClick(view: View){
        val intent = Intent(this,GlossaryActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun saveDays(NumberOfDays: Int){
        val editor = pref?.edit()
        editor?.putInt("days", NumberOfDays)
        editor?.apply()
    }


}