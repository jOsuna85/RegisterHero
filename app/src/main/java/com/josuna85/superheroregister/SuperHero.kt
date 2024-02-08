package com.josuna85.superheroregister

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SuperHero(
            val name: String,
            val alterEgo: String,
            val bio: String,
            val power: Float) : Parcelable