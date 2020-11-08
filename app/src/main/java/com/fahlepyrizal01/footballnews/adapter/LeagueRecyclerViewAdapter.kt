package com.fahlepyrizal01.footballnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahlepyrizal01.core.domain.model.League
import com.fahlepyrizal01.core.utils.Resource.DASH
import com.fahlepyrizal01.footballnews.R
import kotlinx.android.synthetic.main.item_league.view.*

class LeagueRecyclerViewAdapter(val onItemClick: ((String) -> Unit)? = null) :
    RecyclerView.Adapter<LeagueRecyclerViewAdapter.ListViewHolder>() {

    private var listData = ArrayList<League>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_league, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: League) = with(itemView) {
            tv_name_item_league.text = data.strLeague
            tv_alternate_name_item_league.text =
                if (data.strLeagueAlternate.isNullOrEmpty()) DASH else data.strLeagueAlternate

            itemView.setOnClickListener {
                onItemClick?.invoke(data.idLeague)
            }
        }
    }

    fun setData(newListData: List<League>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
}