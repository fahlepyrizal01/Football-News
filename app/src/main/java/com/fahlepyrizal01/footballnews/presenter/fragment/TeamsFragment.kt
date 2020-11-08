package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.adapter.TeamRecyclerViewAdapter
import com.fahlepyrizal01.footballnews.presenter.viewmodel.TeamsViewModel
import kotlinx.android.synthetic.main.fragment_teams.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class TeamsFragment : Fragment() {

    private val viewModel: TeamsViewModel by viewModel()

    private val recyclerViewAdapter by lazy {
        TeamRecyclerViewAdapter(::navigateToTeamDetail)
    }

    private val args: LeagueDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_teams.setNavigationOnClickListener { findNavController().popBackStack() }

        setupRecyclerView()

        viewModel.teams.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    it.getLoadingStateIfNotHandled()?.let {
                        rv_teams_teams.visibility = View.GONE
                        pb_teams.visibility = View.VISIBLE
                    }
                }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let { data ->
                        pb_teams.visibility = View.GONE
                        iv_empty_or_error_teams.visibility = View.GONE
                        recyclerViewAdapter.setData(data)
                        rv_teams_teams.visibility = View.VISIBLE
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                        pb_teams.visibility = View.GONE
                        iv_empty_or_error_teams.visibility = View.VISIBLE
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getTeamList(args.idLeague)
        }
    }

    private fun setupRecyclerView() = with(rv_teams_teams) {
        layoutManager = LinearLayoutManager(context)
        adapter = recyclerViewAdapter
    }

    private fun navigateToTeamDetail(idTeam: String) {
        super.getView()?.findNavController()?.navigate(
            TeamsFragmentDirections.actionTeamsFragmentToTeamDetailFragment(idTeam)
        )
    }

}