package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailTvShowEntity(
    val genres: String,
    val id: Int,
    val firstAirDate: String,
    val overview: String,
    val createdBy: String,
    val posterPath: String,
    val voteAverage: String,
    val name: String
):Parcelable