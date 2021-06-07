package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreditEntity(
    val cast: String,
    val id: Int,
    val crew: String
):Parcelable