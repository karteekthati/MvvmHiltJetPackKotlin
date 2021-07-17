package com.kk.hiltsample.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kk.hiltsample.Adapter.PostAdapter
import com.kk.hiltsample.R
import com.kk.hiltsample.Utils.ApiState
import com.kk.hiltsample.databinding.FragmentHomeBinding
import com.kk.hiltsample.model.Post
import com.kk.hiltsample.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var postAdapter: PostAdapter
    private val mainViewModel: MainViewModel by viewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        initRecycler()
        mainViewModel.getViewModelPost()
        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect{
                when(it){
                    is ApiState.Loading-> {
                        binding.recyclerView.isVisible = false
                        binding.progressBar.isVisible =  true
                    }
                    is ApiState.Failure-> {
                        binding.recyclerView.isVisible = false
                        binding.progressBar.isVisible =  false
                        Log.d("Hilt main", "oncreate: ${it.msg}")
                    }
                    is ApiState.Success->{
                        binding.recyclerView.isVisible = true
                        binding.progressBar.isVisible =  false
                        postAdapter.setData(it.data)
                    }
                    is ApiState.Empty-> {
                        Log.d("Hilt","empty")
                    }
                }
            }
        }
    }

    private fun initRecycler() {
        postAdapter =  PostAdapter(Post())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager =  LinearLayoutManager(activity)
            adapter = postAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}