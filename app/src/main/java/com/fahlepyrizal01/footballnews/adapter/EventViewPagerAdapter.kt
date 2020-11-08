package com.fahlepyrizal01.footballnews.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fahlepyrizal01.footballnews.R
import com.fahlepyrizal01.footballnews.presenter.fragment.EventsFragment

class EventViewPagerAdapter (
    private val context: Context,
    private val idTeam: String,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val tabTitles = intArrayOf(R.string.event_last_event, R.string.event_next_event)

    override fun getItem(position: Int): Fragment {
        return EventsFragment.newInstance(position == LAST_EVENT_POSITION, idTeam)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(tabTitles[position])
    }

    override fun getCount(): Int = TAB_SIZE

    companion object {
        const val TAB_SIZE = 2
        const val LAST_EVENT_POSITION = 0
    }
}