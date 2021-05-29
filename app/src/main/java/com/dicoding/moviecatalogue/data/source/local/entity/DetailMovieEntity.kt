package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailMovieEntity(
    val title: String,
    val genres: String,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: String
):Parcelable