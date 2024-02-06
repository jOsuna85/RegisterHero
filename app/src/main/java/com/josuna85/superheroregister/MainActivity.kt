package com.josuna85.superheroregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josuna85.superheroregister.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.btnSave.setOnClickListener {
            openDetailActivity()
        }
    }

    private fun openDetailActivity(){
        val intent = Intent(this, DetailActivity::class.java)
    }
}