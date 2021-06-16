package com.dicoding.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.data.source.remote.ApiResponse
import com.dicoding.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.moviecatalogue.data.source.remote.response.*
import com.dicoding.moviecatalogue.utils.AppExecutors
import com.dicoding.moviecatalogue.utils.Config
import com.dicoding.moviecatalogue.utils.Utils
import com.dicoding.moviecatalogue.vo.Resource

class FakeCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueDataSource {

    override fun getMovies(page: Int): LiveData<Resource<PagedList<CatalogueEntity>>> {
        val categoryCatalogue = "movie"
        return object :
            NetworkBoundResource<PagedList<CatalogueEntity>, MovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<CatalogueEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getListCatalogue(categoryCatalogue),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<CatalogueEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getMovies(page)

            override fun saveCallResult(data: MovieResponse?) {
                val movieList = ArrayList<CatalogueEntity>()
                if (data?.results != null) {
                    for (response in data.results!!) {
                        val score = if (response.voteCount == 0) {
                            "NR"
                        } else {
                            Utils.removeDecimal(response.voteAverage.times(10)).plus(" %")
                        }
                        val date = if (response.releaseDate.isNullOrEmpty()) {
                            "TBA"
                        } else {
                            Utils.dateConvert(response.releaseDate!!)
                        }
                        val movie = CatalogueEntity(
                            response.id,
                            response.title,
                            date,
                            response.overview,
                            score,
                            Config.imagePath.plus(response.posterPath),
                            categoryCatalogue,
                            "",
                            "",
                            ""
                        )
                        movieList.add(movie)
                    }
                }
                localDataSource.insertListCatalogue(movieList)
            }
        }.asLiveData()
    }

    override fun getTvShows(page: Int): LiveData<Resource<PagedList<CatalogueEntity>>> {
        val categoryCatalogue = "tv"
        return object :
            NetworkBoundResource<PagedList<CatalogueEntity>, TvShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<CatalogueEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getListCatalogue(categoryCatalogue),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<CatalogueEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<TvShowResponse>> =
                remoteDataSource.getTvShows(page)

            override fun saveCallResult(data: TvShowResponse?) {
                val tvShowList = ArrayList<CatalogueEntity>()
                if (data?.results != null) {
                    for (response in data.results!!) {
                        val score = if (response.voteCount == 0) {
                            "NR"
                        } else {
                            Utils.removeDecimal(response.voteAverage.times(10)).plus(" %")
                        }
                        val date = if (response.firstAirDate.isNullOrEmpty()) {
                            "TBA"
                        } else {
                            Utils.dateConvert(response.firstAirDate!!)
                        }
                        val tvShow = CatalogueEntity(
                            response.id,
                            response.name,
                            date,
                            response.overview,
                            score,
                            Config.imagePath.plus(response.posterPath),
                            categoryCatalogue,
                            "",
                            "",
                            ""
                        )
                        tvShowList.add(tvShow)
                    }
                }
                localDataSource.insertListCatalogue(tvShowList)
            }
        }.asLiveData()
    }

    override fun getCredits(id: Int, catalogue: String): LiveData<Resource<CatalogueEntity>> {
        return object : NetworkBoundResource<CatalogueEntity, CreditResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<CatalogueEntity> =
                localDataSource.getCatalogueById(id)

            override fun shouldFetch(data: CatalogueEntity?): Boolean =
                data?.casts?.isEmpty() ?: false

            override fun createCall(): LiveData<ApiResponse<CreditResponse>> =
                remoteDataSource.getCredit(id, catalogue)

            override fun saveCallResult(data: CreditResponse?) {
                var casts = ""
                var directors = ""

                if (data != null) {
                    for (cast in data.cast) {
                        casts = "$casts${cast.name}, "
                    }
                    casts = casts.dropLast(2)

                    for (crew in data.crew) {
                        if (crew.job == "Director") {
                            directors = "$directors${crew.name}, "
                        }
                    }
                    directors = directors.dropLast(2)
                }
                if (catalogue == "tv") {
                    localDataSource.updateCatalogueByCreditTv(casts, id)
                } else if (catalogue == "movie") {
                    localDataSource.updateCatalogueByCreditMovie(casts, directors, id)
                }
            }
        }.asLiveData()
    }

    override fun getDetailMovie(id: Int): LiveData<Resource<CatalogueEntity>> {
        return object : NetworkBoundResource<CatalogueEntity, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<CatalogueEntity> =
                localDataSource.getCatalogueById(id)

            override fun shouldFetch(data: CatalogueEntity?): Boolean =
                data?.genres?.isEmpty() ?: false

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                remoteDataSource.getDetailMovie(id)

            override fun saveCallResult(data: DetailMovieResponse?) {
                var genres = ""
                if (data != null) {
                    for (genre in data.genres) {
                        genres = "$genres${genre.name}, "
                    }
                    genres = genres.dropLast(2)
                }
                localDataSource.updateCatalogueByDetailMovie(genres, id)
            }

        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<CatalogueEntity>> {
        return object : NetworkBoundResource<CatalogueEntity, DetailTvShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<CatalogueEntity> =
                localDataSource.getCatalogueById(id)

            override fun shouldFetch(data: CatalogueEntity?): Boolean =
                data?.genres?.isEmpty() ?: false

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> =
                remoteDataSource.getDetailTv(id)

            override fun saveCallResult(data: DetailTvShowResponse?) {
                var genres = ""
                var creators = ""
                if (data != null) {
                    for (genre in data.genres) {
                        genres = "$genres${genre.name}, "
                    }
                    genres = genres.dropLast(2)
                    for (creator in data.createdBy) {
                        creators = "$creators${creator.name}, "
                    }
                    creators = creators.dropLast(2)
                }

                localDataSource.updateCatalogueByDetailTv(genres, creators, id)
            }

        }.asLiveData()
    }

    override fun insertFavoriteCatalogue(favoriteEntity: FavoriteEntity) {
        localDataSource.insertFavoriteCatalogue(favoriteEntity)
    }

    override fun getListFavorite(catalogue: String): LiveData<PagedList<FavoriteEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListFavorite(catalogue), config).build()
    }

    override fun getFavoriteById(id: Int): LiveData<FavoriteEntity> =
        localDataSource.getFavoriteById(id)

    override fun deleteFavoriteCatalogue(id: Int) {
        localDataSource.deleteFavoriteCatalogue(id)
    }

}