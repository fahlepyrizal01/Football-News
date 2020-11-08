package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.adapter.StandingRecyclerViewAdapter
import com.fahlepyrizal01.footballnews.presenter.viewmodel.StandingsViewModel
import kotlinx.android.synthetic.main.fragment_standings.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class StandingsFragment : Fragment() {

    private val viewModel: StandingsViewModel by viewModel()

    private val recyclerViewAdapter by lazy {
        StandingRecyclerViewAdapter()
    }

    private val args: LeagueDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_standings.setNavigationOnClickListener { findNavController().popBackStack() }

        setupRecyclerView()

        viewModel.standings.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    it.getLoadingStateIfNotHandled()?.let {
                        rv_standing_standing.visibility = View.GONE
                        lav_progress_standings.visibility = View.VISIBLE
                    }
                }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let { data ->
                        lav_progress_standings.visibility = View.GONE
                        lav_empty_or_error_standings.visibility = View.GONE
                        recyclerViewAdapter.setData(data)
                        rv_standing_standing.visibility = View.VISIBLE
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                        lav_progress_standings.visibility = View.GONE
                        lav_empty_or_error_standings.visibility = View.VISIBLE
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getStandingList(args.idLeague)
        }
    }

    override fun onDestroyView() {

        rv_standing_standing.apply {
            addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener{
                override fun onViewAttachedToWindow(v: View?) {}

                override fun onViewDetachedFromWindow(v: View?) {
                    adapter = null
                }

            })
        }

        super.onDestroyView()

    }

    private fun setupRecyclerView() = with(rv_standing_standing) {
        layoutManager = LinearLayoutManager(context)
        adapter = recyclerViewAdapter
    }
}