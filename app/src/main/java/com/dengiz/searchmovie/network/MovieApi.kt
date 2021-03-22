package com.dengiz.searchmovie.network

import com.dengiz.searchmovie.data.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      21/03/2021 - 00:41    ║
╚════════════════════════════╝

 */
interface MovieApi {

    @GET("?apikey=2406e19c")
    suspend fun getSearchFilm(
        @Query("s") nameOfFilm: String = "batman"
    ): Response<MovieResponse>
}