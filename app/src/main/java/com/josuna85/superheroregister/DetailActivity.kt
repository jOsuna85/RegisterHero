package com.josuna85.superheroregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josuna85.superheroregister.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle = intent.extras!!
        val superHeroName:String = bundle.getString("superhero_name") ?: ""
        val alterEgo:String = bundle.getString("alter_ego") ?: ""
        val bio:String = bundle.getString("bio") ?: ""
        val power:Float = bundle.getFloat("power")

        binding.txtviewHeroName.text = superHeroName
        binding.txtvName.text = alterEgo
        binding.txtvBioShort.text = bio
        binding.ratingBar.rating = power


    }
}