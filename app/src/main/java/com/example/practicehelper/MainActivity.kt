package com.example.practicehelper

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practicehelper.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDate()
    }

    @SuppressLint("SetTextI18n")
    private fun setDate(){ //Создаем функцию setDate (Установка даты)
        val c = Calendar.getInstance()  //Получаем все данные из класса Calendar
        val year = c.get(Calendar.YEAR) //Получаем текущий год
        binding.tvDateYear.text = year.toString() // Отображаем год на экране
        var month = c.get(Calendar.MONTH)   //Получаем месяц на 1 меньше чем текущий
        month++ // прибавляем к переменной единицу
        if (month<10){ binding.tvDateMonth.text = "0${month}"} // Проверка на двузначность числа
        else {binding.tvDateMonth.text = month.toString()}
        val day = c.get(Calendar.DAY_OF_MONTH) //Получаем текущий день в месяце
        binding.tvDateDay.text = day.toString() //Отображаем день на экране
    }
    fun btProfileOnClick(view: View){
        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)
    }
    fun btGlossaryOnClick(view: View){
        val intent = Intent(this,GlossaryActivity::class.java)
        startActivity(intent)
    }
    fun btDiaryOnClick(view: View){
        val intent = Intent(this,DiaryActivity::class.java)
        startActivity(intent)
    }
    fun btSettingsOnClick(view:View){

    }
}