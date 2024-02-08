package com.josuna85.superheroregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josuna85.superheroregister.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val SUPERHERO_KEY = "superhero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle = intent.extras!!
        val superHero: SuperHero = bundle.getParcelable(SUPERHERO_KEY)!!

        binding.txtviewHeroName.text = superHero.name
        binding.txtvName.text = superHero.alterEgo
        binding.txtvBioShort.text = superHero.bio
        binding.ratingBar.rating = superHero.power


    }
}