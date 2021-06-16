package com.dicoding.moviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getMovies(page: Int): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<MovieResponse>>()
        val client = ApiConfig.getApiService().getMovie(apiKey, page)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.totalPages == 0) {
                            resultMovies.value = ApiResponse.empty(response.message(), it)
                        } else {
                            resultMovies.value = ApiResponse.success(it)
                        }
                    }
                } else {
                    response.body()
                        ?.let { resultMovies.value = ApiResponse.error(response.message(), it) }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                resultMovies.value = ApiResponse.error(t.message.toString(), null)
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovies
    }

    fun getTvShows(page: Int): LiveData<ApiResponse<TvShowResponse>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<TvShowResponse>>()
        val client = ApiConfig.getApiService().getTvShow(apiKey, page)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.totalResults == 0) {
                            resultTvShows.value = ApiResponse.empty(response.message(), it)
                        } else {
                            resultTvShows.value = ApiResponse.success(it)
                        }
                    }
                } else {
                    response.body()
                        ?.let { resultTvShows.value = ApiResponse.error(response.message(), it) }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                resultTvShows.value = ApiResponse.error(t.message.toString(), null)
                EspressoIdlingResource.decrement()
            }
        })

        return resultTvShows
    }

    fun getCredit(id: Int, catalogue: String): LiveData<ApiResponse<CreditResponse>>  {
        EspressoIdlingResource.increment()
        val resultCredit = MutableLiveData<ApiResponse<CreditResponse>>()
        val client = ApiConfig.getApiService().getCredit(id, catalogue, apiKey)
        client.enqueue(object : Callback<CreditResponse> {
            override fun onResponse(
                call: Call<CreditResponse>,
                response: Response<CreditResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        resultCredit.value = ApiResponse.success(it)
                    }
                } else {
                    response.body()
                        ?.let {
                            resultCredit.value = ApiResponse.error(response.message(), it)
                        }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<CreditResponse>, t: Throwable) {
                resultCredit.value = ApiResponse.error(t.message.toString(), null)
                EspressoIdlingResource.decrement()
            }
        })
        return resultCredit
    }

    fun getDetailMovie(id: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        val client = ApiConfig.getApiService().getDetailMovie(id, apiKey)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        resultDetailMovie.value = ApiResponse.success(it)
                    }
                } else {
                    response.body()
                        ?.let {
                            resultDetailMovie.value = ApiResponse.error(response.message(), it)
                        }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                resultDetailMovie.value = ApiResponse.error(t.message.toString(), null)
                EspressoIdlingResource.decrement()
            }

        })

        return resultDetailMovie
    }

    fun getDetailTv(id: Int): LiveData<ApiResponse<DetailTvShowResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailTv = MutableLiveData<ApiResponse<DetailTvShowResponse>>()
        val client = ApiConfig.getApiService().getDetailTv(id, apiKey)
        client.enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(
                call: Call<DetailTvShowResponse>,
                response: Response<DetailTvShowResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        resultDetailTv.value = ApiResponse.success(it)
                    }
                } else {
                    response.body()
                        ?.let { resultDetailTv.value = ApiResponse.error(response.message(), it) }
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                resultDetailTv.value = ApiResponse.error(t.message.toString(), null)
                EspressoIdlingResource.decrement()
            }
        })
        return resultDetailTv
    }
}