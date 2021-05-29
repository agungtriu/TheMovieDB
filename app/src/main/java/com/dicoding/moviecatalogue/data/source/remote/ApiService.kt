package com.dicoding.moviecatalogue.data.source.remote

import com.dicoding.moviecatalogue.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovie(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("{catalogue}/{id}/credits")
    fun getCredit(
        @Path("id") id: Int,
        @Path("catalogue") catalogue: String,
        @Query("api_key") apiKey: String
    ): Call<CreditResponse>

    @GET("tv/popular")
    fun getTvShow(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<TvShowResponse>

    @GET("tv/{id}")
    fun getDetailTv(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailTvShowResponse>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailMovieResponse>
}