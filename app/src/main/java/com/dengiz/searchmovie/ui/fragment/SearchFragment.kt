package com.dengiz.searchmovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dengiz.searchmovie.R
import com.dengiz.searchmovie.adapter.SearchAdapter
import com.dengiz.searchmovie.databinding.FragmentSearchBinding
import com.dengiz.searchmovie.vm.MovieViewModel

class SearchFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeLiveData()
        eventHandler()
    }

    private fun observeLiveData() {
        viewModel.movieResponseLiveData.observe(viewLifecycleOwner) { result ->

            result?.let {
                searchAdapter.differ.submitList(result.search)
            }
        }
    }

    private fun eventHandler() {

        searchAdapter.setOnItemClickListener { search ->
            val bundle = Bundle().apply {
                putSerializable("search", search)
            }
            findNavController().navigate(
                R.id.action_searchFragment_to_detailFragment3,
                bundle
            )
        }

        binding.etSearch.addTextChangedListener { editable ->
            editable?.let {
                viewModel.getMovies(editable.toString())
            }
        }
    }

    private fun init() {
        searchAdapter = SearchAdapter()
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        binding.recycMovies.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = searchAdapter
        }
    }
}