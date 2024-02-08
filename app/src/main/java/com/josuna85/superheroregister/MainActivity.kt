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
            openDetailActivity(superHeroName, alterEgo, bio, power)
        }
    }

    private fun openDetailActivity(superHeroName:String, alterEgo:String, bio:String, power:Float){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("superhero_name",superHeroName)
        intent.putExtra("alter_ego",alterEgo)
        intent.putExtra("bio",bio)
        intent.putExtra("power",power)
        startActivity(intent)
    }
}