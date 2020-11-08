package com.fahlepyrizal01.favorite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fahlepyrizal01.core.domain.model.Team
import com.fahlepyrizal01.core.utils.Resource.PARENTHESES
import com.fahlepyrizal01.core.utils.Resource.UNDERSCORE
import com.fahlepyrizal01.favorite.R
import com.fahlepyrizal01.footballnews.R as App
import kotlinx.android.synthetic.main.item_favorite_team.view.*


class FavoriteTeamRecyclerViewAdapter(val onItemClick: ((String) -> Unit)? = null) :
    RecyclerView.Adapter<FavoriteTeamRecyclerViewAdapter.ViewHolder>() {

    private var listData = ArrayList<Team>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_favorite_team, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(team: Team) = with(itemView) {
            Glide.with(context).load(team.strTeamBadge).placeholder(App.drawable.ic_image_placeholder).into(iv_logo_favorite_teams)
            tv_name_favorite_teams.text = team.strTeam.plus(PARENTHESES.replace(UNDERSCORE, team.idTeam))

            itemView.setOnClickListener {
                onItemClick?.invoke(team.idTeam)
            }
        }
    }

    fun setData(newListData: List<Team>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
}