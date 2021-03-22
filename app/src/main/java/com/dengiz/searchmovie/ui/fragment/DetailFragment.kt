package com.dengiz.searchmovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.dengiz.searchmovie.R
import com.dengiz.searchmovie.databinding.FragmentDetailBinding
import com.dengiz.searchmovie.utils.downloadFromUrl
import com.dengiz.searchmovie.utils.placeHolderProgressBar

class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        val search = args.search
        binding.movieTitle.text = search.title
        binding.imdb.text = search.imdbID
        binding.type.text = search.type
        binding.photo.apply {
            downloadFromUrl(
                search.poster,
                placeHolderProgressBar(context)
            )
        }
    }
}