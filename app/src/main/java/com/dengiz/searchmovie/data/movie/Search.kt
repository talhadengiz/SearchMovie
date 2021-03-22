package com.dengiz.searchmovie.data.movie

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Search(

	@SerializedName("Title")
	val title: String,

	@SerializedName("imdbID")
	val imdbID: String,

	@SerializedName("Type")
	val type: String,

	@SerializedName("Poster")
	val poster: String
) : Serializable