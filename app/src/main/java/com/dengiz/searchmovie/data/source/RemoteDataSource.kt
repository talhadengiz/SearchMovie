package com.dengiz.searchmovie.data.source

import com.dengiz.searchmovie.network.RetrofitProvider

/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      21/03/2021 - 00:25    ║
╚════════════════════════════╝
 */
class RemoteDataSource {

    suspend fun searchFilms(searchQuery: String) =
        RetrofitProvider.api.getSearchFilm(searchQuery)
}