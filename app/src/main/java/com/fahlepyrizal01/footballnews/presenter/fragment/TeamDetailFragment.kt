package com.fahlepyrizal01.footballnews.presenter.fragment

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.Team
import com.fahlepyrizal01.core.utils.Resource.DASH
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.adapter.EventViewPagerAdapter
import com.fahlepyrizal01.footballnews.presenter.viewmodel.TeamDetailViewModel
import kotlinx.android.synthetic.main.fragment_team_detail.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class TeamDetailFragment : Fragment() {

    private val viewModel: TeamDetailViewModel by viewModel()

    private val args: TeamDetailFragmentArgs by navArgs()

    private val viewPagerAdapter by lazy {
        context?.let { EventViewPagerAdapter(it, args.idTeam, childFragmentManager) }
    }

    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_team_detail.setNavigationOnClickListener { findNavController().popBackStack() }

        setupViewPager()

        viewModel.team.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    it.getLoadingStateIfNotHandled()?.let {
                        pb_team_detail.visibility = View.VISIBLE
                    }
                }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let { data ->
                        pb_team_detail.visibility = View.GONE
                        setupUi(data)
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                        pb_team_detail.visibility = View.GONE
                        Toast.makeText(context,
                            context?.getString(R.string.team_detail_toast_failed_label), Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getTeamDetail(args.idTeam)
        }

    }

    private fun setFavorite() {
        context?.let {
            fab_favorite_team_detail.setColorFilter(
                ContextCompat.getColor(it, if (isFavorite) R.color.pink else R.color.white),
                PorterDuff.Mode.SRC_IN
            )
        }
    }

    private fun setupUi(data: Team) = with(data) {
        context?.let { Glide.with(it).load(strTeamBadge).placeholder(R.drawable.ic_image_placeholder).into(iv_logo_team_detail) }
        tv_id_value_team_detail.text = idTeam
        tv_name_value_team_detail.text = strTeam ?: DASH
        tv_stadium_value_team_detail.text = strStadium ?: DASH
        tv_formed_year_value_team_detail.text = intFormedYear ?: DASH
        tv_league_value_team_detail.text = strLeague ?: DASH
        tv_gender_value_team_detail.text = strGender ?: DASH
        tv_country_value_team_detail.text = strCountry ?: DASH
        tv_website_value_team_detail.text = strWebsite ?: DASH
        tv_facebook_value_team_detail.text = strFacebook ?: DASH
        tv_twitter_value_team_detail.text = strTwitter ?: DASH
        tv_youtube_value_team_detail.text = strYoutube ?: DASH

        this@TeamDetailFragment.isFavorite = isFavorite ?: false

        setFavorite()

        fab_favorite_team_detail.setOnClickListener {
            this@TeamDetailFragment.isFavorite = !this@TeamDetailFragment.isFavorite

            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.updateIsFavorite(data, this@TeamDetailFragment.isFavorite)
            }
        }
    }

    private fun setupViewPager() {
        tl_team_detail.setupWithViewPager(vp_team_detail)
        vp_team_detail.adapter = viewPagerAdapter
    }

}