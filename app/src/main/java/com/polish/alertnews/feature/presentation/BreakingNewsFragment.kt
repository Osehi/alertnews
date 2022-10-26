package com.polish.alertnews.feature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polish.alertnews.common.utils.resource.Resource
import com.polish.alertnews.databinding.FragmentBreakingNewsBinding
import com.polish.alertnews.feature.data.network.model.newsarticle.Article
import com.polish.alertnews.feature.presentation.adapter.BreakingNewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BreakingNewsFragment : Fragment() {

    /**
     * declare variables
     */
    private val TAG = "BREAKINGNEWS"
    private var _binding: FragmentBreakingNewsBinding? = null
    private val binding: FragmentBreakingNewsBinding get() = _binding!!
    private val breakingNewsViewModel: BreakingNewViewModel by viewModels()
    private lateinit var breakingNewRecyclerView: RecyclerView
    private lateinit var breakingNewsAdapter: BreakingNewsAdapter
    private val list = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        breakingNewRecyclerView = binding.breakingNewsFragmentRecyclerviewRv
        breakingNewRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        // Testing the network
        breakingNewsViewModel.getBreakingNews("us")
        // observers
        initObserver()
    }

    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                breakingNewsViewModel.breakingNewsResponse.collect {
                    when (it) {
                        is Resource.Success -> {
                            breakingNewsAdapter = BreakingNewsAdapter(it.data.articles as List<Article>)
                            breakingNewRecyclerView.adapter = breakingNewsAdapter
                            breakingNewsAdapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                        }
                        is Resource.Loading -> {
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
