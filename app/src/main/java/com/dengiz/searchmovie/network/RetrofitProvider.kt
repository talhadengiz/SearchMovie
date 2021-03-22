package com.dengiz.searchmovie.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      21/03/2021 - 01:17    ║
╚════════════════════════════╝
 */
object RetrofitProvider {
    private const val BASE_URL = "https://www.omdbapi.com/"

    private val retrofit by lazy {

        val client = OkHttpClient.Builder()
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api by lazy {
        retrofit.create(MovieApi::class.java)
    }
}