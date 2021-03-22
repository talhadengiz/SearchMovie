package com.dengiz.searchmovie.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dengiz.searchmovie.data.movie.MovieResponse
import com.dengiz.searchmovie.data.repository.MovieRepository
import com.dengiz.searchmovie.data.source.RemoteDataSource
import kotlinx.coroutines.launch
import java.io.IOException


/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      20/03/2021 - 23:09    ║
╚════════════════════════════╝
 */
class MovieViewModel : ViewModel() {

    private val repository = MovieRepository(RemoteDataSource())
    var movieResponseLiveData: MutableLiveData<MovieResponse> = MutableLiveData()

    fun getMovies(searchQuery: String) = viewModelScope.launch {
        try {

            val response = repository.remoteDataSource.searchFilms(searchQuery)
            Log.d("Movie", "veri: ${response.body()}")

            if (response.isSuccessful) {
                movieResponseLiveData.postValue(response.body())
            }

        } catch (exception: IOException) {
            Log.d("Movie", "exception: $exception")
        }
    }
}