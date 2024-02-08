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
            val superHeroName:String = binding.edtxtHeroName.text.toString()
            val alterEgo:String = binding.edtxtAlterEgo.text.toString()
            val bio:String = binding.edtxtBioDescription.text.toString()
            val power: Float = binding.powerbarRating.rating

            val hero = SuperHero(superHeroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }
    }

    private fun openDetailActivity(superHero: SuperHero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY,superHero)
        startActivity(intent)
    }
}