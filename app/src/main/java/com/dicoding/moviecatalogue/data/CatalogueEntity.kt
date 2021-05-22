package com.dicoding.moviecatalogue.data

data class CatalogueEntity (
    var catalogueId: String,
    var catalogueTitle: String,
    var catalogueRelease: String,
    var catalogueOverview: String,
    var catalogueScore: String,
    var catalogueGenres: String,
    var catalogueDirector: String,
    var catalogueCast: String,
    var cataloguePoster: String
)