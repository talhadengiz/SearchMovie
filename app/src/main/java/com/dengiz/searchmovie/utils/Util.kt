package com.dengiz.searchmovie.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dengiz.searchmovie.R


/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      22/03/2021 - 01:00    ║
╚════════════════════════════╝
 */

fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable) {

    val options = RequestOptions().placeholder(progressDrawable).error(R.mipmap.ic_launcher)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)


}

fun placeHolderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}