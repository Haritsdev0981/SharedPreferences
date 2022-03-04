package com.harets.testdzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IntegerRes
import com.harets.testdzikir.databinding.ActivityMainBinding
import com.harets.testdzikir.ui.home.HomeActivity

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("SHARE_PREF", MODE_PRIVATE)

        binding.apply {
            btnSave.setOnClickListener {
                // input data
                val name = nameEt.text.toString().trim()
                val age = Integer.parseInt(ageEt.text.toString().trim())
                val experienced = switchh.isChecked // if checked the true else false

                // shared preference (to put data)
                val editor = sharedPreferences.edit()
                // put data om shared preference
                editor.putString("NAME", name)
                editor.putInt("AGE", age)
                editor.putBoolean("EXPERIENCED", experienced)
                // apply changes to shared preferences
                editor.apply()

                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                finish()
            }

            btnShowinf.setOnClickListener {
                // get data from shared preferences
                val name = sharedPreferences.getString("NAME", "")
                val age = sharedPreferences.getInt("AGE", 0)
                val experience = sharedPreferences.getBoolean("EXPERIENCED", false)
                // show data in text view
                tvInfo.text = "Name: $name \nAge: $age \nExperience: $experience"
            }
        }
    }
}