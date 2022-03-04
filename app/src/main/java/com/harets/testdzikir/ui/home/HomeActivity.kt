package com.harets.testdzikir.ui.home

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harets.testdzikir.MainActivity
import com.harets.testdzikir.R
import com.harets.testdzikir.databinding.ActivityHomeBinding
import com.harets.testdzikir.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding as ActivityHomeBinding

    lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preference = getSharedPreferences("SHARE_PREF", MODE_PRIVATE)

        val name = preference.getString("NAME", "")
        binding.txtTitle.text = name

        val age = preference.getInt("AGE", 0)
        binding.txtAge.text = ""+age

        binding.btnLogout.setOnClickListener {
            val editor: SharedPreferences.Editor = preference.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}