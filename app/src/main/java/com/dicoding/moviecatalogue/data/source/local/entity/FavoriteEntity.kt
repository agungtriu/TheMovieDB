package com.dicoding.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "favoriteentities")
data class FavoriteEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "release")
    var release: String,
    @ColumnInfo(name = "overview")
    var overview: String,
    @ColumnInfo(name = "score")
    var score: String,
    @ColumnInfo(name = "poster")
    var poster: String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "genres")
    val genres: String,
    @ColumnInfo(name = "creator")
    val creator: String,
    @ColumnInfo(name = "casts")
    val casts: String
) : Parcelable