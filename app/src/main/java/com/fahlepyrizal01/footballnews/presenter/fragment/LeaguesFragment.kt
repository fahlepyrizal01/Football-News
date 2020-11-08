package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.adapter.LeagueRecyclerViewAdapter
import com.fahlepyrizal01.footballnews.presenter.viewmodel.LeaguesViewModel
import kotlinx.android.synthetic.main.fragment_leagues.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class LeaguesFragment : Fragment() {

    private val viewModel: LeaguesViewModel by viewModel()

    private val recyclerViewAdapter by lazy {
        LeagueRecyclerViewAdapter(::navigateToLeagueDetail)
    }

    private var isChildMenuShow = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_leagues, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.leagues.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    it.getLoadingStateIfNotHandled()?.let {
                        rv_league_league.visibility = View.GONE
                        pb_league.visibility = View.VISIBLE
                    }
                }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let { data ->
                        pb_league.visibility = View.GONE
                        recyclerViewAdapter.setData(data)
                        rv_league_league.visibility = View.VISIBLE
                        iv_empty_or_error_leagues.visibility = View.GONE
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                        pb_league.visibility = View.GONE
                        iv_empty_or_error_leagues.visibility = View.VISIBLE
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getLeagueList()
        }

        fab_menu_league.setOnClickListener {
            isChildMenuShow = !isChildMenuShow

            if (isChildMenuShow) {
                View.VISIBLE
            } else {
                View.GONE
            }.let {
                fab_favorite_league.visibility = it
                fab_search_league.visibility = it
            }
        }

        fab_favorite_league.setOnClickListener {
            super.getView()?.findNavController()?.navigate(
                LeaguesFragmentDirections.actionLeaguesFragmentToFavoriteTeamsFragment()
            )
        }

        fab_search_league.setOnClickListener {
            super.getView()?.findNavController()?.navigate(
                LeaguesFragmentDirections.actionLeaguesFragmentToSearchTeamsFragment()
            )
        }
    }

    private fun setupRecyclerView() = with(rv_league_league) {
        layoutManager = GridLayoutManager(context, SPAN_COUNT_LEAGUE_ITEM)
        adapter = recyclerViewAdapter
    }

    private fun navigateToLeagueDetail(idLeague: String) {
        super.getView()?.findNavController()?.navigate(
            LeaguesFragmentDirections.actionLeaguesFragmentToLeagueDetailFragment(idLeague)
        )
    }

    companion object {
        const val SPAN_COUNT_LEAGUE_ITEM = 2
    }

}