package com.mike.commitbrowser.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mike.commitbrowser.R
import com.mike.commitbrowser.adapters.CommitItemAdapter
import com.mike.commitbrowser.databinding.FragmentHomeBinding
import com.mike.commitbrowser.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home,
            container, false
        )

        //Set up recyclewview adapter
        val adapter = CommitItemAdapter()

        // Set databinding bindings
        binding.homeViewModel = homeViewModel

        binding.recyclerviewCommits.adapter = adapter

        binding.lifecycleOwner = this


        // Observe commits from vm and update list on changes
        homeViewModel.commits.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}