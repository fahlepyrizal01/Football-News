package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.adapter.TeamRecyclerViewAdapter
import com.fahlepyrizal01.footballnews.presenter.viewmodel.SearchTeamsViewModel
import kotlinx.android.synthetic.main.fragment_search_teams.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SearchTeamsFragment : Fragment() {

    private val viewModel: SearchTeamsViewModel by viewModel()

    private val recyclerViewAdapter by lazy {
        TeamRecyclerViewAdapter(::navigateToTeamDetail)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_teams, container, false)
    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_back_search_teams.setOnClickListener { findNavController().popBackStack() }

        setupRecyclerView()

        sv_search_teams.isIconifiedByDefault = false
        sv_search_teams.requestFocus()

        viewModel.search.observe(viewLifecycleOwner, {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.searchTeams(it)
            }
        })

        viewModel.teams.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    it.getLoadingStateIfNotHandled()?.let {
                        rv_teams_search_teams.visibility = View.GONE
                        pb_search_teams.visibility = View.VISIBLE
                    }
                }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let { data ->
                        pb_search_teams.visibility = View.GONE
                        iv_empty_or_error_search_teams.visibility = View.GONE
                        recyclerViewAdapter.setData(data)
                        rv_teams_search_teams.visibility = View.VISIBLE
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                        pb_search_teams.visibility = View.GONE
                        iv_empty_or_error_search_teams.visibility = View.VISIBLE
                    }
                }
            }

        })

        sv_search_teams.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.queryChannel.send(query.orEmpty())
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.queryChannel.send(newText.orEmpty())
                }

                return false
            }

        })

        cv_search_teams.setOnClickListener { sv_search_teams.requestFocus() }
    }

    private fun setupRecyclerView() = with(rv_teams_search_teams) {
        layoutManager = LinearLayoutManager(context)
        adapter = recyclerViewAdapter
    }

    private fun navigateToTeamDetail(idTeam: String) {
        super.getView()?.findNavController()?.navigate(
            SearchTeamsFragmentDirections.actionSearchTeamsFragmentToTeamDetailFragment(idTeam)
        )
    }

}