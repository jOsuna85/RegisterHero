package com.josuna85.superheroregister

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josuna85.superheroregister.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val SUPERHERO_KEY = "superhero"
        const val BITMAP_KEY = "bitmap"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle = intent.extras!!
        val superHero: SuperHero = bundle.getParcelable(SUPERHERO_KEY)!!
        val bitmap: Bitmap = bundle.getParcelable(BITMAP_KEY)!!

        binding.imageV.setImageBitmap(bitmap)// se asigna la foto a imageview
        binding.superhero = superHero

        /*Al utilizar el data binding no podemos ahorrar estas declaraciones y codigos de lineas
        asignadolos directamente a los views
        binding.txtviewHeroName.text = superHero.name
        binding.txtvName.text = superHero.alterEgo
        binding.txtvBioShort.text = superHero.bio
        binding.ratingBar.rating = superHero.power*/


    }
}