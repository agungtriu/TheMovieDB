package com.dicoding.moviecatalogue.data.source.remote

import android.util.Log
import com.dicoding.moviecatalogue.data.source.remote.response.*
import com.dicoding.moviecatalogue.helper.EspressoIdlingResource
import com.dicoding.moviecatalogue.utils.Config.apiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMovies(page: Int, callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovie(apiKey, page)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    callback.onAllMoviesReceived(response.body()?.results as List<MovieItem>)
                } else {
                    Log.e("RemoteDataSource", "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShows(page: Int, callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTvShow(apiKey, page)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    callback.onAllTvShowReceived(response.body()?.results as List<TvShowItem>)
                } else {
                    Log.e("RemoteDataSource", "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getCredit(id: Int, catalogue: String, callback: LoadCreditCallback) {
        val client = ApiConfig.getApiService().getCredit(id, catalogue, apiKey)
        client.enqueue(object : Callback<CreditResponse> {
            override fun onResponse(
                call: Call<CreditResponse>,
                response: Response<CreditResponse>
            ) {
                if (response.isSuccessful) {
                    callback.onAllCreditReceived(response.body() as CreditResponse)
                } else {
                    Log.e("RemoteDataSource", "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<CreditResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailMovie(id: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailMovie(id, apiKey)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                if (response.isSuccessful) {
                    callback.onAllDetailMovieReceived(response.body() as DetailMovieResponse)
                } else {
                    Log.e("RemoteDataSource", "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getDetailTv(id: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailTv(id, apiKey)
        client.enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(
                call: Call<DetailTvShowResponse>,
                response: Response<DetailTvShowResponse>
            ) {
                if (response.isSuccessful) {
                    callback.onAllDetailTvShowReceived(response.body() as DetailTvShowResponse)
                } else {
                    Log.e("RemoteDataSource", "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(listMovieItem: List<MovieItem>)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowReceived(listTvShowsItem: List<TvShowItem>)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMovieReceived(detailMovieResponse: DetailMovieResponse)
    }

    interface LoadDetailTvShowCallback {
        fun onAllDetailTvShowReceived(detailTvShowResponse: DetailTvShowResponse)
    }

    interface LoadCreditCallback {
        fun onAllCreditReceived(creditResponse: CreditResponse)
    }
}