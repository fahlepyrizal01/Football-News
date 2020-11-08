package com.fahlepyrizal01.favorite.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahlepyrizal01.favorite.R
import com.fahlepyrizal01.favorite.adapter.FavoriteTeamRecyclerViewAdapter
import com.fahlepyrizal01.favorite.di.favoriteModule
import com.fahlepyrizal01.favorite.presenter.viewmodel.FavoriteTeamsViewModel
import kotlinx.android.synthetic.main.fragment_favorite_teams.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteTeamsFragment : Fragment() {

    private val viewModel: FavoriteTeamsViewModel by viewModel()

    private val recyclerViewAdapter by lazy {
        FavoriteTeamRecyclerViewAdapter(::navigateToTeamDetail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadKoinModules(favoriteModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_favorite_teams.setNavigationOnClickListener { findNavController().popBackStack() }

        setupRecyclerView()

        viewModel.teams.observe(viewLifecycleOwner, {
            pb_search_teams.visibility = View.GONE
            if (it.isNullOrEmpty()) {
                iv_empty_or_error_search_teams.visibility = View.VISIBLE
                rv_teams_search_teams.visibility = View.GONE
            } else {
                iv_empty_or_error_search_teams.visibility = View.GONE
                recyclerViewAdapter.setData(it)
                rv_teams_search_teams.visibility = View.VISIBLE
            }
        })

        pb_search_teams.visibility = View.VISIBLE
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getFavoriteList()
        }
    }

    private fun setupRecyclerView() = with(rv_teams_search_teams) {
        layoutManager = LinearLayoutManager(context)
        adapter = recyclerViewAdapter
    }

    private fun navigateToTeamDetail(idTeam: String) {
        super.getView()?.findNavController()?.navigate(
            FavoriteTeamsFragmentDirections.actionFavoriteFragmentToTeamDetailFragment(idTeam)
        )
    }

}