package com.dicoding.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CrewItem(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("profile_path")
    val profilePath: String?,

    @field:SerializedName("job")
    val job: String
) : Parcelable
