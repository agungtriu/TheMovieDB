package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatalogueDetailEntity (
    var catalogueId: Int,
    var catalogueTitle: String,
    var catalogueRelease: String,
    var catalogueOverview: String,
    var catalogueScore: String,
    var catalogueGenres: String,
    var catalogueDirector: String,
    var catalogueCast: String,
    var cataloguePoster: String
): Parcelable