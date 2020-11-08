package com.fahlepyrizal01.footballnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahlepyrizal01.core.domain.model.Event
import com.fahlepyrizal01.core.utils.Resource.DASH
import com.fahlepyrizal01.footballnews.R
import kotlinx.android.synthetic.main.item_event.view.*

class EventRecyclerViewAdapter : RecyclerView.Adapter<EventRecyclerViewAdapter.ListViewHolder>() {

    private var listData = ArrayList<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Event) = with(itemView) {

            tv_date_events.text = data.dateEvent.plus(" ${data.strTime}")
            tv_home_name_events.text = data.strHomeTeam ?: DASH
            tv_home_score_events.text = data.intHomeScore ?: DASH
            tv_away_name_events.text = data.strAwayTeam ?: DASH
            tv_away_score_events.text = data.intAwayScore ?: DASH
        }
    }

    fun setData(newListData: List<Event>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
}