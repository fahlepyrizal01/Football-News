package com.fahlepyrizal01.footballnews.presenter.fragment

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.LeagueDetail
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.presenter.viewmodel.LeagueDetailViewModel
import kotlinx.android.synthetic.main.fragment_league_detail.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class LeagueDetailFragment : Fragment() {

    private val viewModel: LeagueDetailViewModel by viewModel()

    private val args: LeagueDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_league_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_league_detail.setNavigationOnClickListener { findNavController().popBackStack() }

        viewModel.league.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    it.getLoadingStateIfNotHandled()?.let {
                        pb_league_detail.visibility = View.VISIBLE
                    }
                }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let { data ->
                        pb_league_detail.visibility = View.GONE
                        iv_empty_or_error_league_detail.visibility = View.GONE
                        setupUi(data)
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                        pb_league_detail.visibility = View.GONE
                        iv_empty_or_error_league_detail.visibility = View.VISIBLE
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getLeagueDetail(args.idLeague)
        }
    }

    private fun setupUi(data: LeagueDetail) {
        context?.let { it ->
            Glide.with(it).load(data.strPoster).placeholder(R.drawable.ic_image_placeholder).into(iv_flag_league_detail)
            Glide.with(it).load(data.strBadge).placeholder(R.drawable.ic_image_placeholder).into(iv_logo_league_detail)
        }
        tv_name_league_detail.text = data.strLeague
        tv_id_league_detail.text = data.idLeague


        tv_description_league_detail.text =
            HtmlCompat.fromHtml(data.strDescriptionEN.orEmpty(), HtmlCompat.FROM_HTML_MODE_COMPACT)


        btn_see_table_league_detail.setOnClickListener {
            super.getView()?.findNavController()?.navigate(
                LeagueDetailFragmentDirections.actionLeagueDetailFragmentToStandingsFragment(args.idLeague)
            )
        }

        btb_see_team_league_detail.setOnClickListener {
            super.getView()?.findNavController()?.navigate(
                LeagueDetailFragmentDirections.actionLeagueDetailFragmentToTeamsFragment(args.idLeague)
            )
        }
    }
}