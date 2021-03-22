package com.dengiz.searchmovie.data.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("Search")
    val search: List<Search>,

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("Response")
    val response: Boolean
)