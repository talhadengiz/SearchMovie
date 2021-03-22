package com.dengiz.searchmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dengiz.searchmovie.data.movie.Search
import com.dengiz.searchmovie.databinding.MovieItemLayoutBinding
import com.dengiz.searchmovie.utils.downloadFromUrl
import com.dengiz.searchmovie.utils.placeHolderProgressBar


/**     Code with ❤
╔════════════════════════════╗
║  Created by İ.Talha Dengiz ║
╠════════════════════════════╣
║    talhadengiz@gmail.com   ║
╠════════════════════════════╣
║      22/03/2021 - 00:31    ║
╚════════════════════════════╝
 */
class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    inner class SearchViewHolder(val binding: MovieItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Search>() {
        override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem.poster == newItem.poster
        }

        override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {

        return SearchViewHolder(
            MovieItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        holder.binding.tvMovieName.text = differ.currentList[position].title
        holder.binding.imgPoster.downloadFromUrl(
            differ.currentList[position].poster,
            placeHolderProgressBar(holder.itemView.context)
        )

        holder.binding.imgPoster.setOnClickListener {
            onItemClickListener?.let {
                it(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Search) -> Unit)? = null

    fun setOnItemClickListener(listener: (Search) -> Unit) {
        onItemClickListener = listener
    }
}