package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatalogueEntity(
    var id: Int,
    var title: String,
    var release: String,
    var overview: String,
    var score: String,
    var poster: String
):Parcelable
