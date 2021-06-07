package com.dicoding.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.CreditEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailMovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailTvShowEntity
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.data.source.remote.response.*
import com.dicoding.moviecatalogue.utils.Config
import com.dicoding.moviecatalogue.utils.Utils

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {

    override fun getMovies(page: Int): LiveData<List<CatalogueEntity>> {
        val movieResult = MutableLiveData<List<CatalogueEntity>>()
        remoteDataSource.getMovies(page, object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(listMovieItem: List<MovieItem>) {
                val movieList = ArrayList<CatalogueEntity>()
                for (response in listMovieItem) {
                    val score = Utils.removeDecimal(response.voteAverage.times(10)).plus("%")
                    val movie = CatalogueEntity(
                        response.id,
                        response.title,
                        Utils.dateConvert(response.releaseDate),
                        response.overview,
                        score,
                        Config.imagePath.plus(response.posterPath)
                    )
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }

        })
        return movieResult
    }

    override fun getTvShows(page: Int): LiveData<List<CatalogueEntity>> {
        val tvShowResult = MutableLiveData<List<CatalogueEntity>>()
        remoteDataSource.getTvShows(page, object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowReceived(listTvShowsItem: List<TvShowItem>) {
                val tvShowList = ArrayList<CatalogueEntity>()
                for (response in listTvShowsItem) {
                    val score = Utils.removeDecimal(response.voteAverage.times(10)).plus("%")
                    val tvShow = CatalogueEntity(
                        response.id,
                        response.name,
                        Utils.dateConvert(response.firstAirDate),
                        response.overview,
                        score,
                        Config.imagePath.plus(response.posterPath)
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResult.postValue(tvShowList)
            }
        })
        return tvShowResult
    }

    override fun getCredits(id: Int, catalogue: String): LiveData<CreditEntity> {
        val creditResult = MutableLiveData<CreditEntity>()
        remoteDataSource.getCredit(id, catalogue, object : RemoteDataSource.LoadCreditCallback {
            override fun onAllCreditReceived(creditResponse: CreditResponse) {
                var casts = ""
                for (cast in creditResponse.cast) {
                    casts = "$casts${cast.name}, "
                }
                casts = casts.dropLast(2)

                var directors = ""
                for (crew in creditResponse.crew) {
                    if (crew.job == "Director") {
                        directors = "$directors${crew.name}, "
                    }
                }
                directors = directors.dropLast(2)

                creditResult.postValue(
                    CreditEntity(
                        casts,
                        creditResponse.id,
                        directors
                    )
                )
            }
        })
        return creditResult
    }

    override fun getDetailMovie(id: Int): LiveData<DetailMovieEntity> {
        val detailMovieResult = MutableLiveData<DetailMovieEntity>()
        remoteDataSource.getDetailMovie(
            id,
            object : RemoteDataSource.LoadDetailMovieCallback {
                override fun onAllDetailMovieReceived(detailMovieResponse: DetailMovieResponse) {
                    var genres = ""
                    for (genre in detailMovieResponse.genres) {
                        genres = "$genres${genre.name}, "
                    }
                    val score =
                        Utils.removeDecimal(detailMovieResponse.voteAverage.times(10)).plus("%")
                    detailMovieResult.postValue(
                        DetailMovieEntity(
                            detailMovieResponse.title,
                            genres,
                            detailMovieResponse.id,
                            detailMovieResponse.overview,
                            detailMovieResponse.posterPath,
                            Utils.dateConvert(detailMovieResponse.releaseDate),
                            score
                        )
                    )
                }
            })

        return detailMovieResult
    }

    override fun getDetailTvShow(id: Int): LiveData<DetailTvShowEntity> {
        val detailTvShowResult = MutableLiveData<DetailTvShowEntity>()
        remoteDataSource.getDetailTv(
            id,
            object : RemoteDataSource.LoadDetailTvShowCallback {
                override fun onAllDetailTvShowReceived(detailTvShowResponse: DetailTvShowResponse) {
                    var genres = ""
                    for (genre in detailTvShowResponse.genres) {
                        genres = "$genres${genre.name}, "
                    }
                    genres = genres.dropLast(2)
                    var creators = ""
                    for (creator in detailTvShowResponse.createdBy) {
                        creators = "$creators${creator.name}, "
                    }
                    creators = creators.dropLast(2)
                    val score =
                        Utils.removeDecimal(detailTvShowResponse.voteAverage.times(10)).plus("%")
                    detailTvShowResult.postValue(
                        DetailTvShowEntity(
                            genres,
                            detailTvShowResponse.id,
                            Utils.dateConvert(detailTvShowResponse.firstAirDate),
                            detailTvShowResponse.overview,
                            creators,
                            detailTvShowResponse.posterPath,
                            score,
                            detailTvShowResponse.name
                        )
                    )
                }
            })

        return detailTvShowResult
    }
}
