package com.dengiz.searchmovie.data.repository

import com.dengiz.searchmovie.data.source.RemoteDataSource


/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      21/03/2021 - 00:26    ║
╚════════════════════════════╝
 */
class MovieRepository(
    val remoteDataSource: RemoteDataSource
) {
    suspend fun getMovies(searchQuery: String) {
        remoteDataSource.searchFilms(searchQuery)
    }
}