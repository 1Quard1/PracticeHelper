package com.example.practicehelper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practicehelper.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding
    lateinit var pref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("PROFILE", Context.MODE_PRIVATE)
        getUserData()
    }

    fun btNavHomeOnClick(view: View){
        finish()
    }

    fun btNavDiaryOnClick(view: View){
        val intent = Intent(this,DiaryActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btNavGlossaryOnClick(view: View){
        val intent = Intent(this,GlossaryActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btSaveDataOnClick(view: View){
        saveUserData()
    }

private fun saveUserData(){
    val prefEdit = pref.edit()
    val name = binding.etName.text
    val secondName = binding.etSecondName.text
    val group = binding.etGroup.text
    val nameShip = binding.etNameShip.text
    prefEdit.putString("name", name.toString())
    prefEdit.putString("second_name", secondName.toString())
    prefEdit.putString("group", group.toString())
    prefEdit.putString("name_ship", nameShip.toString())
    prefEdit.apply()
}

    private fun getUserData(){
        val name = pref.getString("name","")!! //Получаем данные из хранилища
        binding.etName.setText(name) // Отображаем полученные данные на экране
        val secondName = pref.getString("second_name","")!!
        binding.etSecondName.setText(secondName)
        val group = pref.getString("group","")!!
        binding.etGroup.setText(group)
        val nameShip = pref.getString("name_ship","")!!
        binding.etNameShip.setText(nameShip)
    }
}